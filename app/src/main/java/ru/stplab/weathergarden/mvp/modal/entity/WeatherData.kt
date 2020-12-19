package ru.stplab.weathergarden.mvp.modal.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize


@Parcelize
data class WeatherData(

    @Expose val lat : Double,
    @Expose val lon : Double,
    @Expose val timezone : String,
    @Expose val timezone_offset : Int,
    @Expose val current : Current,
    @Expose val hourly : List<Hourly>,
    @Expose val daily : List<Daily>

):Parcelable