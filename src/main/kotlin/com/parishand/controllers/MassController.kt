package com.parishand.controllers

import com.parishand.controllers.request.MassRequest
import com.parishand.models.MassModel
import com.parishand.services.MassService
import com.parishand.services.ParishService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("paroquias")
class MassController(
    val parishService: ParishService,
    val massService: MassService
) {
    @PostMapping("/{parishId}/missas")
    @ResponseStatus(HttpStatus.CREATED)
    fun createMass(@PathVariable parishId: Int, @RequestBody massRequest: MassRequest) {
        val parishModel = parishService.getById(parishId)
        massService.create(massRequest.toMassModel(parishModel))
    }

    @GetMapping("/{parishId}/missas")
    fun findAllMass(@PathVariable parishId: Int, @RequestParam massDescription: String?): Iterable<MassModel> {
        val parishModel = parishService.getById(parishId)
        return massService.findAll(parishModel, massDescription)
    }

    @PutMapping("/{parishId}/missas/{massId}")
    fun updateMass(@PathVariable parishId: Int, massId: Int, @RequestBody massRequest: MassRequest) {
        val parishModel = parishService.getById(parishId)
        return massService.updateOne(massRequest.toMassModel(parishModel, parishId))
    }

    @DeleteMapping("/{parishId}/missas/{massId}")
    fun deleteMass(@PathVariable massId: Int) {
        return massService.deleteOne(massId)
    }
}