package com.parishand.controllers.request

import com.parishand.models.MassModel
import com.parishand.models.ParishModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


data class MassRequest(
    val description: String,
    val dateHour: String
) {
    fun toMassModel(parish: ParishModel, id: Int): MassModel {
        return MassModel(
            id = id,
            description = description,
            dateHour = this.dateHourAdapter(dateHour),
            parish = parish
        )
    }

    fun toMassModel(parish: ParishModel): MassModel {
        return MassModel(
            description = description,
            dateHour = this.dateHourAdapter(dateHour),
            parish = parish
        )
    }

    private fun dateHourAdapter(stringDate: String): String {
        return LocalDateTime.parse(stringDate, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")).toString()
    }
}