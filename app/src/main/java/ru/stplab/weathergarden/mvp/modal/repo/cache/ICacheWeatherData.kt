package ru.stplab.weathergarden.mvp.modal.repo.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.stplab.weathergarden.mvp.modal.entity.City
import ru.stplab.weathergarden.mvp.modal.entity.WeatherData

interface ICacheWeatherData {

    fun putWeatherData(city: City, weather: WeatherData): Completable
    fun getWeatherData(city: City): Single<WeatherData>
}