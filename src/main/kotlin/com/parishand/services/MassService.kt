package com.parishand.services

import com.parishand.exceptions.MassNotFoundException
import com.parishand.models.MassModel
import com.parishand.models.ParishModel
import com.parishand.repositories.MassRepositoryInterface
import org.springframework.stereotype.Service

@Service
class MassService(
    val massRepositoryInterface: MassRepositoryInterface,
) {
    fun create(mass: MassModel) {
        massRepositoryInterface.save(mass)
    }

    fun findAll(parish: ParishModel, massDescription: String?): Iterable<MassModel> {

        val massList = massRepositoryInterface.findByParishId(parish.id)

        massDescription?.let {
           return  massList.filter {
                it.description.contains(massDescription)
            }
        }

        return massList;
    }

    fun updateOne(mass: MassModel) {

        this.getById(mass.id!!);

        massRepositoryInterface.save(mass)
    }

    fun deleteOne(id: Int) {

        this.getById(id);

        massRepositoryInterface.deleteById(id)
    }

    fun getById(id: Int): MassModel{

        if (massRepositoryInterface.existsById(id)) {
            throw MassNotFoundException()
        }

        return massRepositoryInterface.findById(id).get()
    }
}