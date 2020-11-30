package com.dsb.rest.controller

import com.dsb.rest.dao.EquipementsDAO
import com.dsb.rest.model.Equipement
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.io.IOException

@RestController
@RequestMapping(path = ["/ceintures"])
class CeinturesController(private val equipementsDAO: EquipementsDAO) {
    @GetMapping(path = ["/all"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @Throws(
        IOException::class
    )
    fun getAll(@RequestParam page: Int): List<Equipement> {
        return equipementsDAO.getAllEquipements(dir, page)
    }

    @get:Throws(
        IOException::class
    )
    @get:GetMapping(path = ["/total"], produces = [MediaType.APPLICATION_JSON_VALUE])
    val total: Int
        get() = equipementsDAO.getTotalEquipement(dir)

    @GetMapping(path = ["/"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @Throws(
        IOException::class
    )
    fun filter(
        @RequestParam page: Int,
        @RequestParam level: Int,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) stats: List<String>
    ): List<Equipement> {
        return equipementsDAO.filter(dir, page, level, name, stats)
    }

    companion object {
        const val dir = "src/main/resources/ceintures.json"
    }
}