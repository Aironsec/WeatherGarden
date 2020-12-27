package ru.stplab.weathergarden.mvp.modal.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.stplab.weathergarden.BuildConfig
import ru.stplab.weathergarden.mvp.modal.entity.WeatherData

interface IDataSource {

    @GET("data/2.5/onecall")
    fun getWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "ru",
        @Query("appid") keyApi: String = BuildConfig.WEATHER_API_KEY

    ): Single<WeatherData>
}