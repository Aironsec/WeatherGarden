package ru.stplab.weathergarden.mvp.modal.repo

import io.reactivex.rxjava3.core.Single
import ru.stplab.weathergarden.mvp.modal.entity.City
import ru.stplab.weathergarden.mvp.modal.entity.WeatherData

interface IWeatherDataRepo {

    fun getWeatherForCity(city: City): Single<WeatherData>
}