package ru.stplab.weathergarden.mvp.modal.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather (

	val id : Int,
	val main : String,
	val description : String,
	@Expose val icon : String

): Parcelable