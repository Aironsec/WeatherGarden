package ru.stplab.weathergarden.mvp.modal.repo.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.stplab.weathergarden.mvp.modal.entity.City

interface ICacheLocateCity {

    fun putCity(city: City): Completable
    fun getCities(): Single<List<City>>
}