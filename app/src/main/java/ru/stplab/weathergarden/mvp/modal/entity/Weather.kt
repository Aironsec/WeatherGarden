package ru.stplab.weathergarden.mvp.modal.entity

import com.google.gson.annotations.Expose

data class Weather (

	@Expose val icon : String,
	val id : Int? = null,
	val main : String? = null,
	val description : String? = null

)