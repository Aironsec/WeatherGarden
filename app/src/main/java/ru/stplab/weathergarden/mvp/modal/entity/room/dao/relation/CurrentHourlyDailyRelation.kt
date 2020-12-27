package ru.stplab.weathergarden.mvp.modal.entity.room.dao.relation

import androidx.room.Embedded
import androidx.room.Relation
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomCity
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomCurrent
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomDaily
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomHourly

data class CurrentHourlyDailyRelation(
    @Embedded val roomCity: RoomCity,
    @Relation(entity = RoomCurrent::class, parentColumn = "postalCode", entityColumn = "cityPostalCode")
    val roomCurrent: RoomCurrent,
    @Relation(entity = RoomHourly::class, parentColumn = "postalCode", entityColumn = "cityPostalCode")
    val roomHourly: List<RoomHourly>,
    @Relation(entity = RoomDaily::class, parentColumn = "postalCode", entityColumn = "cityPostalCode")
    val roomDaily: List<RoomDaily>
)