package ru.stplab.weathergarden.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution
import ru.stplab.weathergarden.mvp.modal.entity.WeatherData

@AddToEndSingle
interface WeatherView: MvpView {
    fun init()
    fun updateList()
    fun updateCityNameSubCityName(city: String, subCity: String)
    @OneExecution
    fun showBottomSheet(pressure: String, humidity: String, speedWind: String)
}