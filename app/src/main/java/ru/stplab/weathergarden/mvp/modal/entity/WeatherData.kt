package ru.stplab.weathergarden.mvp.modal.entity

import com.google.gson.annotations.Expose

data class WeatherData(

    @Expose val lat : Double,
    @Expose val lon : Double,
    @Expose val current : Current,
    @Expose val hourly : List<Hourly>,
    @Expose val daily : List<Daily>,
    val timezone_offset : Int? = null,
    val timezone : String? = null

)