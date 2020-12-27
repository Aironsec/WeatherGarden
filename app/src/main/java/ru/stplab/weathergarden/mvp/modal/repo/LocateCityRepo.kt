package ru.stplab.weathergarden.mvp.modal.repo

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.stplab.weathergarden.mvp.modal.entity.City
import ru.stplab.weathergarden.mvp.modal.locate.ILocate
import ru.stplab.weathergarden.mvp.modal.repo.cache.ICacheLocateCity
import java.lang.RuntimeException

class LocateCityRepo(
    private val locale: ILocate,
    private val cacheLocateCity: ICacheLocateCity
) :
    ILocateCityRepo {
    override fun getCityFromLocate(): Single<City> =

        locale.getLocate().flatMap { address ->
            address[0]?.let {
                City(it.postalCode, it.locality, it.adminArea, it.latitude, it.longitude). let { city ->
                    cacheLocateCity.putCity(city).toSingleDefault(city)
                }
            }?: Single.error<City>(RuntimeException("Address error"))
                .subscribeOn(Schedulers.io())
        }.subscribeOn(Schedulers.io())
}