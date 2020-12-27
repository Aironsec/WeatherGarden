package ru.stplab.weathergarden.mvp.modal.network

import io.reactivex.rxjava3.core.Single

interface INetworkState {
    fun isOnlineSingle(): Single<Boolean>
}