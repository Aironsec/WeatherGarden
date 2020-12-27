package ru.stplab.weathergarden.mvp.modal.entity.room.dao

import androidx.room.*
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomCurrent
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomDaily
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomHourly
import ru.stplab.weathergarden.mvp.modal.entity.room.dao.relation.CurrentHourlyDailyRelation

@Dao
abstract class WeatherDao {

    @Insert abstract fun insertCurrent(roomCurrent: RoomCurrent)
    @Insert abstract fun insertDailies(roomDaily: List<RoomDaily>)
    @Insert abstract fun insertHourlies(roomHourly: List<RoomHourly>)

    @Update abstract fun updateCurrent(roomCurrent: RoomCurrent)
    @Update abstract fun updateDailies(roomDaily: List<RoomDaily>)
    @Update abstract fun updateHourlies(roomHourly: List<RoomHourly>)

    @Transaction @Insert
    fun insertCurrentHourliesDailies(roomCurrent: RoomCurrent, roomDaily: List<RoomDaily>, roomHourly: List<RoomHourly>) {
        insertCurrent(roomCurrent)
        insertDailies(roomDaily)
        insertHourlies(roomHourly)
    }

    @Transaction @Update
    fun updateCurrentHourliesDailies(roomCurrent: RoomCurrent, roomDaily: List<RoomDaily>, roomHourly: List<RoomHourly>) {
        updateCurrent(roomCurrent)
        updateDailies(roomDaily)
        updateHourlies(roomHourly)
    }

    @Transaction @Query("SELECT * FROM RoomCity WHERE postalCode = :postalCode LIMIT 1")
    abstract fun findCityWithWeather(postalCode: String): CurrentHourlyDailyRelation


    @Query("SELECT * FROM RoomCurrent WHERE cityPostalCode = :postalCode LIMIT 1")
    abstract fun findCurrentWeather(postalCode: String): RoomCurrent?
}