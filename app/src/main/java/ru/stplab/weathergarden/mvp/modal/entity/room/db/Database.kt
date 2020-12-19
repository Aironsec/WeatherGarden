package ru.stplab.weathergarden.mvp.modal.entity.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.stplab.weathergarden.mvp.modal.entity.room.CityWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.CurrentWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.DailyWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.HourlyWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.dao.CityDao
import ru.stplab.weathergarden.mvp.modal.entity.room.dao.WeatherDao

@Database(
    entities = [
        CityWeather::class,
        CurrentWeather::class,
        DailyWeather::class,
        HourlyWeather::class
    ], version = 1
)
abstract class Database: RoomDatabase() {
    abstract val cityDao: CityDao
    abstract val weatherDao: WeatherDao

    companion object{
        const val DB_NAME = "weather_data.db"
    }
}