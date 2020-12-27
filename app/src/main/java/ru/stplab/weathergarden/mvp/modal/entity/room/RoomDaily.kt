package ru.stplab.weathergarden.mvp.modal.entity.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomCity::class,
        parentColumns = ["postalCode"],
        childColumns = ["cityPostalCode"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("cityPostalCode")]
)
class RoomDaily(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var dt: Int,
    var sunrise: Int,
    var sunset: Int,
// TODO: 19.12.2020  вынести в отдельную таблицу?
    var day: Double,
    var min: Double,
    var max: Double,
    var night: Double,
    var eve: Double,
    var morn: Double,
// TODO: 19.12.2020
    var pressure: Int,
    var humidity: Int,
    var windSpeed: Double,
    var windDeg: Int,
    var icon: String,
    var pop: Double,
    var cityPostalCode: String
)