package com.dsb.rest.dao

import com.dsb.rest.model.Panoplie
import com.dsb.rest.model.PanoplieBonus
import com.dsb.rest.model.Statistic
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Repository
import java.io.File

@Repository
class PanopliesDAO {

    companion object {
        private val mapper = ObjectMapper().registerModule(KotlinModule())
    }

    fun getAllPanoplies() = deserializedPanoplie()

    fun getStatsOfPanoplieBonus(id: Int, numberOfItemInPanoplie: Int): List<Statistic> {
        return deserializedPanoplieBonus(id).bonus.find {
                it.number == numberOfItemInPanoplie
            }?.stats ?: emptyList()
    }

    private fun deserializedPanoplieBonus(id: Int): PanoplieBonus {
        return mapper.readValue(File("src/main/resources/panopliebonus/$id.json"))
    }

    private fun deserializedPanoplie(): List<Panoplie> {
        return mapper.readValue(File("src/main/resources/panoplies.json"))
    }
}