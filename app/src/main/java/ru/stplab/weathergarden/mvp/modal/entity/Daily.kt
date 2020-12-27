package ru.stplab.weathergarden.mvp.modal.entity

import com.google.gson.annotations.Expose

data class Daily (

    @Expose val dt : Int,
    @Expose val sunrise : Int,
    @Expose val sunset : Int,
    @Expose val temp : Temp,
    @Expose val pressure : Int,
    @Expose val humidity : Int,
    @Expose val windSpeed : Double,
    @Expose val windDeg : Int,
    @Expose val weather : List<Weather>,
    @Expose val pop : Double,
    val feelsLike : FeelsLike? = null,
    val dewPoint : Double? = null,
    val clouds : Int? = null,
    val uvi : Int? = null

)