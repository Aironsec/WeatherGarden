package ru.stplab.weathergarden.mvp.modal.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(

    val postalCode: String,
    val cityName: String,
    val citySubName: String,
    val lat: Double,
    val lon: Double

):Parcelable