package ru.stplab.weathergarden.mvp.modal.repo

import io.reactivex.rxjava3.core.Single
import ru.stplab.weathergarden.mvp.modal.entity.City

interface ILocateCityRepo {
    fun getCityFromLocate(): Single<City>
}