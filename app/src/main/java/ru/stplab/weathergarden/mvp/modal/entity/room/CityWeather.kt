package ru.stplab.weathergarden.mvp.modal.entity.room

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index("id", "cityName", "cityRegion")])
class CityWeather(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var cityName: String,
    var cityRegion: String,
    var lat: Double,
    var lon: Double,
    var timeUpdate: Long
)