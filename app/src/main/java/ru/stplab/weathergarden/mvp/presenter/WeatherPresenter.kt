package ru.stplab.weathergarden.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.stplab.weathergarden.mvp.modal.entity.Hourly
import ru.stplab.weathergarden.mvp.modal.repo.ILocateCityRepo
import ru.stplab.weathergarden.mvp.modal.repo.IWeatherDataRepo
import ru.stplab.weathergarden.mvp.presenter.list.IHoursListPresenter
import ru.stplab.weathergarden.mvp.view.WeatherView
import ru.stplab.weathergarden.mvp.view.list.IHoursItemView
import ru.terrakok.cicerone.Router
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class WeatherPresenter : MvpPresenter<WeatherView>() {

    @Inject lateinit var router: Router
    @Inject lateinit var uiScheduler: Scheduler
    @Inject lateinit var locateCityRepo: ILocateCityRepo
    @Inject lateinit var retrofitWeatherDataRepo: IWeatherDataRepo

    class HoursListPresenter : IHoursListPresenter {
        override var itemClickListener: ((IHoursItemView) -> Unit)? = null

        val hours = mutableListOf<Hourly>()

        override fun bindView(view: IHoursItemView) {
            val hour = hours[view.pos]
            view.setTemps(hour.temp.toString())
            hour.weather[0].icon.let {
                view.loadImage("https://openweathermap.org/img/wn/$it@2x.png")
            }
            val hourFormat =
                SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(hour.dt * 1000.toLong()))
            view.setHour(hourFormat)
        }

        override fun getCount() = hours.size
    }

    val hoursListPresenter = HoursListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        hoursListPresenter.itemClickListener = { view ->
            val hour = hoursListPresenter.hours[view.pos]
            viewState.showBottomSheet(
                hour.pressure.toString(),
                hour.humidity.toString(),
                hour.windSpeed.toString()
            )
        }
    }

    private fun loadData() {
        locateCityRepo.getCityFromLocate()
            .observeOn(uiScheduler)
            .subscribe ({ city ->
                viewState.updateCityNameSubCityName(city.cityName, city.citySubName)
                retrofitWeatherDataRepo.getWeatherForCity(city)
                    .observeOn(uiScheduler)
                    .subscribe { data ->
                        hoursListPresenter.hours.clear()
                        hoursListPresenter.hours.addAll(data.hourly)
                        viewState.updateList()
                    }
            },{
                print("Error ${it.message}")
            })

    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}