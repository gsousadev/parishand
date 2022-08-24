package com.parishand.repositories

import com.parishand.models.MassModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MassRepositoryInterface : CrudRepository<MassModel, Int> {
    fun findByParishId(parishId: Int?): List<MassModel>
}