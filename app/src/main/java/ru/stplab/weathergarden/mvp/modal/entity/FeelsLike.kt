package ru.stplab.weathergarden.mvp.modal.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeelsLike (

	@Expose val day : Double,
	@Expose val night : Double,
	@Expose val eve : Double,
	@Expose val morn : Double

): Parcelable