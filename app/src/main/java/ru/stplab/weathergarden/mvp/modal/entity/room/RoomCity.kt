package ru.stplab.weathergarden.mvp.modal.entity.room

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index("postalCode", "cityName")])
class RoomCity(
    @PrimaryKey
    var postalCode: String,
    var cityName: String,
    var citySubName: String,
    var lat: Double,
    var lon: Double
)