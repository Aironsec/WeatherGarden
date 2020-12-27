package ru.stplab.weathergarden.mvp.modal.locate

import android.location.Address
import io.reactivex.rxjava3.core.Single

interface ILocate {
    fun getLocate(): Single<List<Address?>>
}