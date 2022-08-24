package com.parishand.controllers.request

import com.parishand.models.ParishModel

data class ParishRequest(
    val name: String,
    val address: String,
    val zipCode: String,
    val cnpj: String
) {

    fun toParishModel(): ParishModel {
        return ParishModel(
            name = name,
            address = address,
            zipCode = zipCode,
            cnpj = cnpj
        )
    }

    fun toParishModel(id: Int): ParishModel {
        return ParishModel(
            id = id,
            name = name,
            address = address,
            zipCode = zipCode,
            cnpj = cnpj
        )
    }
}