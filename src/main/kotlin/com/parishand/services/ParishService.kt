package com.parishand.services

import com.parishand.exceptions.ParishNotFoundException
import com.parishand.models.ParishModel
import com.parishand.repositories.ParishRepositoryInterface
import org.springframework.stereotype.Service

@Service
class ParishService(
    val parishRepositoryInterface: ParishRepositoryInterface
) {
    fun create(parish: ParishModel) {
        parishRepositoryInterface.save(parish)
    }

    fun findAll(name: String?): Iterable<ParishModel> {

        name?.let {
            return parishRepositoryInterface.findByNameContaining(name)
        }

        return parishRepositoryInterface.findAll()
    }

    fun updateOne(parish: ParishModel) {
        if (!parishRepositoryInterface.existsById(parish.id!!)) {
            throw ParishNotFoundException()
        }

        parishRepositoryInterface.save(parish)
    }

    fun deleteOne(id: Int) {
        if (!parishRepositoryInterface.existsById(id)) {
            throw ParishNotFoundException()
        }

        parishRepositoryInterface.deleteById(id)
    }

    fun getById(id: Int): ParishModel {
        return parishRepositoryInterface.findById(id).get()
    }
}