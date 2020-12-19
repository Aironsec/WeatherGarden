package ru.stplab.weathergarden.mvp.modal.entity.room.dao

import androidx.room.*
import ru.stplab.weathergarden.mvp.modal.entity.room.CityWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.dao.relation.CurrentHourlyDaily

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cityWeather: CityWeather)

    @Update
    fun update(cityWeather: CityWeather)

    @Delete
    fun delete(cityWeather: CityWeather)

    @Query("SELECT * FROM CityWeather ORDER BY cityName")
    fun getAll(): List<CityWeather>

    @Transaction
    @Query("SELECT * FROM CityWeather ORDER BY cityName")
    fun getAllWithWeather(): List<CurrentHourlyDaily>

    @Query("SELECT * FROM CityWeather WHERE cityName = :cityName AND cityRegion = :cityRegion LIMIT 1")
    fun findCity(cityName: String, cityRegion: String): CityWeather?
}