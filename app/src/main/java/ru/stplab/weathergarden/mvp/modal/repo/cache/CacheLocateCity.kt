package ru.stplab.weathergarden.mvp.modal.repo.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.stplab.weathergarden.mvp.modal.entity.City
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomCity
import ru.stplab.weathergarden.mvp.modal.entity.room.db.Database

class CacheLocateCity(private val db: Database) : ICacheLocateCity {

    override fun putCity(city: City): Completable =
        Completable.fromAction {
            val roomCity = db.cityDao.findCityByPostalCode(city.postalCode)
            if (roomCity != null) {
                val newCity = RoomCity(
                    city.postalCode,
                    city.cityName,
                    city.citySubName,
                    city.lat,
                    city.lon
                )
                db.cityDao.update(newCity)
            } else {
                val newCity = RoomCity(
                    city.postalCode,
                    city.cityName,
                    city.citySubName,
                    city.lat,
                    city.lon
                )
                db.cityDao.insert(newCity)
            }

        }.subscribeOn(Schedulers.io())


    override fun getCities(): Single<List<City>> =
        Single.fromCallable {
            db.cityDao.getAll().map { roomCity ->
                with(roomCity) {
                    City(postalCode, cityName, citySubName, lat, lon)
                }
            }
        }.subscribeOn(Schedulers.io())

}