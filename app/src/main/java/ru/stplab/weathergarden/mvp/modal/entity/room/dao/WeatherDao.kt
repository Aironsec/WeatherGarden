package ru.stplab.weathergarden.mvp.modal.entity.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import ru.stplab.weathergarden.mvp.modal.entity.room.CurrentWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.DailyWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.HourlyWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.dao.relation.CurrentHourlyDaily

@Dao
abstract class WeatherDao {

    @Insert abstract fun insertCurrent(currentWeather: CurrentWeather)
    @Insert abstract fun insertDailies(dailyWeather: List<DailyWeather>)
    @Insert abstract fun insertHourlies(hourlyWeather: List<HourlyWeather>)

    @Transaction @Insert
    fun insertCurrentHourliesDailies(currentWeather: CurrentWeather, dailyWeather: List<DailyWeather>, hourlyWeather: List<HourlyWeather>) {
        insertCurrent(currentWeather)
        insertDailies(dailyWeather)
        insertHourlies(hourlyWeather)
    }

    @Transaction @Query("SELECT * FROM CityWeather WHERE id = :id")
    abstract fun findCityWithWeather(id: Long): List<CurrentHourlyDaily>
}