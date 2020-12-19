package ru.stplab.weathergarden.mvp.modal.entity.room.dao.relation

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Transaction
import ru.stplab.weathergarden.mvp.modal.entity.room.CityWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.CurrentWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.DailyWeather
import ru.stplab.weathergarden.mvp.modal.entity.room.HourlyWeather
data class CurrentHourlyDaily(
    @Embedded val cityWeather: CityWeather,
    @Relation(entity = CurrentWeather::class, parentColumn = "id", entityColumn = "cityWeatherId")
    val currentWeather: CurrentWeather,
    @Relation(entity = HourlyWeather::class, parentColumn = "id", entityColumn = "cityWeatherId")
    val hourlyWeather: List<HourlyWeather>,
    @Relation(entity = DailyWeather::class, parentColumn = "id", entityColumn = "cityWeatherId")
    val dailyWeather: List<DailyWeather>
)