package ru.stplab.weathergarden.mvp.modal.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Current (

	@Expose val dt : Int,
	@Expose val sunrise : Int,
	@Expose val sunset : Int,
	@Expose val temp : Double,
	val feelsLike : Double,
	@Expose val pressure : Int,
	@Expose val humidity : Int,
	val dewPoint : Double,
	val uvi : Double,
	val clouds : Int,
	val visibility : Int,
	@Expose val windSpeed : Double,
	@Expose val windDeg : Int,
	@Expose val weather : List<Weather>

): Parcelable