package ru.stplab.weathergarden.mvp.modal.entity.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = CityWeather::class,
        parentColumns = ["id"],
        childColumns = ["cityWeatherId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("cityWeatherId")]
)
class CurrentWeather(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var dt: Int,
    var sunrise: Int,
    var sunset: Int,
    var temp: Double,
    var pressure: Int,
    var humidity: Int,
    var wind_speed: Double,
    var wind_deg: Int,
    var icon: String,
    var cityWeatherId: Long
)