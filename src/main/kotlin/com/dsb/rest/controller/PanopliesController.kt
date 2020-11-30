package com.dsb.rest.controller

import com.dsb.rest.dao.PanopliesDAO
import com.dsb.rest.model.Panoplie
import com.dsb.rest.model.Statistic
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.io.IOException

@RestController
@RequestMapping(path = ["/panoplies"])
class PanopliesController(private val panopliesDAO: PanopliesDAO) {
    @Throws(
        IOException::class
    )
    @GetMapping(path = ["/all"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllPanoplies(): List<Panoplie> = panopliesDAO.getAllPanoplies()

    @GetMapping(path = ["/"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @Throws(
        IOException::class
    )
    fun getPanoplie(@RequestParam id: Int, @RequestParam numberOfItemInPanoplie: Int): List<Statistic> {
        return panopliesDAO.getStatsOfPanoplieBonus(id, numberOfItemInPanoplie)
    }
}