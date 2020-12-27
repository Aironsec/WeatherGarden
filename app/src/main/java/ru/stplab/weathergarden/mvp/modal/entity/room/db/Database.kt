package ru.stplab.weathergarden.mvp.modal.entity.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomCity
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomCurrent
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomDaily
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomHourly
import ru.stplab.weathergarden.mvp.modal.entity.room.dao.CityDao
import ru.stplab.weathergarden.mvp.modal.entity.room.dao.WeatherDao

@Database(
    entities = [
        RoomCity::class,
        RoomCurrent::class,
        RoomDaily::class,
        RoomHourly::class
    ], version = 1
)
abstract class Database: RoomDatabase() {
    abstract val cityDao: CityDao
    abstract val weatherDao: WeatherDao

    companion object{
        const val DB_NAME = "weather_data.db"
    }
}