package ru.stplab.weathergarden.mvp.modal.entity

import com.google.gson.annotations.Expose

data class Current (

	@Expose val dt : Int,
	@Expose val sunrise : Int,
	@Expose val sunset : Int,
	@Expose val temp : Double,
	@Expose val pressure : Int,
	@Expose val humidity : Int,
	@Expose val windSpeed : Double,
	@Expose val windDeg : Int,
	@Expose val weather : List<Weather>,
	val feelsLike : Double? = null,
	val dewPoint : Double? = null,
	val uvi : Double? = null,
	val clouds : Int? = null,
	val visibility : Int? = null

)