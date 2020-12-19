package ru.stplab.weathergarden.mvp.modal.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Daily (

    @Expose val dt : Int,
    @Expose val sunrise : Int,
    @Expose val sunset : Int,
    @Expose val temp : Temp,
    val feelsLike : FeelsLike,
    @Expose val pressure : Int,
    @Expose val humidity : Int,
    val dewPoint : Double,
    @Expose val windSpeed : Double,
    @Expose val windDeg : Int,
    @Expose val weather : List<Weather>,
    val clouds : Int,
    @Expose val pop : Int,
    val uvi : Int

): Parcelable