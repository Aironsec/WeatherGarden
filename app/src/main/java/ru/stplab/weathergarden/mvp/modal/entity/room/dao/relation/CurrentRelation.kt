package ru.stplab.weathergarden.mvp.modal.entity.room.dao.relation

import androidx.room.Embedded
import androidx.room.Relation
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomCity
import ru.stplab.weathergarden.mvp.modal.entity.room.RoomCurrent

class CurrentRelation(
    @Embedded
    val roomCity: RoomCity,
    @Relation(entity = RoomCurrent::class, parentColumn = "postalCode", entityColumn = "cityPostalCode")
    val roomCurrent: RoomCurrent
)