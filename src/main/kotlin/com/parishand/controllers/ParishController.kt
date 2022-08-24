package com.parishand.controllers

import com.parishand.controllers.request.ParishRequest
import com.parishand.models.ParishModel
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
class ParishController(
    val parishService: ParishService,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody parishRequest: ParishRequest) {
        parishService.create(parishRequest.toParishModel())
    }

    @GetMapping
    fun findAll(@RequestParam name: String?): Iterable<ParishModel> {
        return parishService.findAll(name)
    }

    @PutMapping("/{parishId}")
    fun update(@PathVariable parishId: Int, @RequestBody parishRequest: ParishRequest) {
        return parishService.updateOne(parishRequest.toParishModel(parishId))
    }

    @DeleteMapping("/{parishId}",)
    fun delete(@PathVariable parishId: Int) {
        return parishService.deleteOne(parishId)
    }
}