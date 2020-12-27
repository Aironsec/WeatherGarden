package ru.stplab.weathergarden.mvp.modal.repo

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.stplab.weathergarden.mvp.modal.api.IDataSource
import ru.stplab.weathergarden.mvp.modal.entity.City
import ru.stplab.weathergarden.mvp.modal.entity.WeatherData
import ru.stplab.weathergarden.mvp.modal.network.INetworkState
import ru.stplab.weathergarden.mvp.modal.repo.cache.ICacheWeatherData

class RetrofitWeatherDataRepo(
    private val networkState: INetworkState,
    private val api: IDataSource,
    private val cacheData: ICacheWeatherData
) : IWeatherDataRepo {

    override fun getWeatherForCity(city: City): Single<WeatherData> =
        networkState.isOnlineSingle().flatMap { state ->
            if (state) {
                api.getWeatherData(city.lat, city.lon).flatMap { data ->
                    cacheData.putWeatherData(city, data).andThen(Single.just(data))
                }
            } else {
                cacheData.getWeatherData(city)
            }
        }.subscribeOn(Schedulers.io())
}