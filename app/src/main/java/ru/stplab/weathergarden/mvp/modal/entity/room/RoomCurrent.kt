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
class RoomCurrent(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var dt: Int,
    var sunrise: Int,
    var sunset: Int,
    var temp: Double,
    var pressure: Int,
    var humidity: Int,
    var windSpeed: Double,
    var windDeg: Int,
    var icon: String,
    var cityPostalCode: String
)