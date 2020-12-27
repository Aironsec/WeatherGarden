package ru.stplab.weathergarden.mvp.modal.repo.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.stplab.weathergarden.mvp.modal.entity.*
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomCurrent
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomDaily
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomHourly
import ru.stplab.weathergarden.mvp.modal.entity.room.db.Database

class CacheWeatherData(private val db: Database) : ICacheWeatherData {

    override fun putWeatherData(city: City, weather: WeatherData): Completable =
        Completable.fromAction {
            val cityRoom = db.cityDao.findCityByPostalCode(city.postalCode)
            cityRoom?.let {
                val roomCurrentWeather = weather.current.run {
                    RoomCurrent(0, dt, sunrise, sunset, temp, pressure, humidity, windSpeed, windDeg, this.weather[0].icon, cityRoom.postalCode)
                }
                val roomDailyWeather = weather.daily.map { dailies ->
                    with(dailies) {
                        RoomDaily(0, dt, sunrise, sunset, temp.day, temp.min, temp.max, temp.night, temp.eve, temp.morn, pressure, humidity, windSpeed, windDeg, this.weather[0].icon, pop, cityRoom.postalCode)
                    }
                }
                val roomHourlyWeather = weather.hourly.map { hourlies ->
                    with(hourlies) {
                        RoomHourly(0, dt, temp, pressure, humidity, windSpeed, windDeg, this.weather[0].icon, pop, cityRoom.postalCode)
                    }
                }

                val currentRoom = db.weatherDao.findCurrentWeather(it.postalCode)
                if (currentRoom == null) {
                    db.weatherDao.insertCurrentHourliesDailies(
                        roomCurrentWeather,
                        roomDailyWeather,
                        roomHourlyWeather
                    )
                } else {
                    db.weatherDao.updateCurrentHourliesDailies(
                        roomCurrentWeather,
                        roomDailyWeather,
                        roomHourlyWeather
                    )
                }

            }?: Completable.error(RuntimeException("No city"))

        }.subscribeOn(Schedulers.io())

    override fun getWeatherData(city: City): Single<WeatherData> =
        Single.fromCallable {
            val cityRoom = db.cityDao.findCityByPostalCode(city.postalCode)
            cityRoom?.let{
                db.weatherDao.findCityWithWeather(it.postalCode).let { data ->
                    with(data) {
                        WeatherData(
                            roomCity.lat,
                            roomCity.lon,
                            with(roomCurrent){
                                Current(dt, sunrise, sunset, temp,pressure, humidity, windSpeed, windDeg, listOf(Weather(icon)))
                            },
                            roomHourly.map { hourly ->
                                with(hourly){
                                    Hourly(dt, temp, pressure, humidity,windSpeed, windDeg, listOf(Weather(icon)), pop)
                                }
                            },
                            roomDaily.map { daily ->
                                with(daily){
                                    Daily(dt, sunrise, sunset, Temp(day, min, max, night, eve, morn), pressure, humidity, windSpeed, windDeg, listOf(Weather(icon)), pop)
                                }
                            }
                        )
                    }
                }
            }
        }
}