package ru.stplab.weathergarden.mvp.modal.entity

import com.google.gson.annotations.Expose

data class Temp (

	@Expose val day : Double,
	@Expose val min : Double,
	@Expose val max : Double,
	@Expose val night : Double,
	@Expose val eve : Double,
	@Expose val morn : Double

)