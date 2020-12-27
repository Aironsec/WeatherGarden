package ru.stplab.weathergarden.mvp.modal.entity.room.dao

import androidx.room.*
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomCity
import ru.stplab.weathergarden.mvp.modal.entity.room.dao.relation.CurrentRelation

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(roomCity: RoomCity)

    @Update
    fun update(roomCity: RoomCity)

    @Delete
    fun delete(roomCity: RoomCity)

    @Query("SELECT * FROM RoomCity ORDER BY cityName")
    fun getAll(): List<RoomCity>

    @Transaction
    @Query("SELECT * FROM RoomCity ORDER BY cityName")
    fun getAllWithWeather(): List<CurrentRelation>

    @Query("SELECT * FROM RoomCity WHERE cityName = :cityName LIMIT 1")
    fun findCityByName(cityName: String): RoomCity?

    @Query("SELECT * FROM RoomCity WHERE postalCode = :postalCode LIMIT 1")
    fun findCityByPostalCode(postalCode: String): RoomCity?
}