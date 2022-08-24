package com.parishand.repositories

import com.parishand.models.ParishModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ParishRepositoryInterface: CrudRepository<ParishModel, Int> {

    fun findByNameContaining(name: String): List<ParishModel>
}