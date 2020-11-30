package com.dsb.rest.dao

import com.dsb.rest.model.Equipement
import com.dsb.rest.model.Statistic
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.FileReader
import java.util.function.Consumer
import java.util.regex.Pattern
import java.util.stream.Collectors

class EquipementsDAO {

    companion object {
        private const val pageSize = 50

        private val mapper = ObjectMapper().registerModule(KotlinModule())

        private var equipmentListSort: List<Equipement>? = null
        private var lastFilteredStats: List<String>? = null
    }

    fun getAllEquipements(dir: String, page: Int): List<Equipement> {
        return deserialized(dir).sortedBy { it.level }
            .take(pageSize * (page * 1))
            .drop(pageSize * (page - 1))
            .asReversed()
    }

    fun getTotalEquipement(dir: String): Int {
        val equipmentList = deserialized(dir)
        return equipmentList.size
    }

    fun filter(
        dir: String,
        page: Int,
        level: Int,
        name: String?,
        stats: List<String>
    ): List<Equipement> {
        return when {
            name != null -> filterEquipementsByName(dir, page, level, name)
            stats.isNotEmpty() -> filterEquipementsByStat(dir, page, level, stats)
            else -> filterEquipementsByLevel(dir, page, level)
        }
    }

    fun filterEquipementsByLevel(dir: String, page: Int, level: Int): List<Equipement> {
        val equipmentList: List<Equipement> = if (equipmentListSort != null) {
            equipmentListSort!!
        } else {
            deserialized(dir)
        }
        equipmentListSort = equipmentList
            .filter { it.level.toInt() <= level }
            .take(pageSize * (page * 1))
            .drop(pageSize * (page - 1))
            .asReversed()
        return equipmentListSort!!
    }

    fun filterEquipementsByName(dir: String, page: Int, level: Int, name: String): List<Equipement> {
        equipmentListSort = deserialized(dir)
            .filter { Pattern.compile(Pattern.quote(name), Pattern.CASE_INSENSITIVE).matcher(it.name).find() }
            .filter { it.level.toInt() <= level }
            .take(pageSize * (page * 1))
            .drop(pageSize * (page - 1))
            .asReversed()
        return equipmentListSort!!
    }

    fun filterEquipementsByStat(dir: String, page: Int, level: Int, stats: List<String>): List<Equipement> {
        val equipmentList: List<Equipement> = if (equipmentListSort != null) {
            if (stats.size < lastFilteredStats!!.size) {
                deserialized(dir)
            } else {
                equipmentListSort!!
            }
        } else {
            deserialized(dir)
        }
        lastFilteredStats = stats
        stats.forEach(
            Consumer { s: String ->
                equipmentListSort = equipmentList
                    .stream()
                    .filter { (_, _, _, _, statistics) ->
                        statistics.stream().anyMatch(Statistic.getPredicateByLabel(s))
                    }
                    .filter { (_, _, level1) -> level1.toInt() <= level }
                    .collect(Collectors.toList())
            }
        )
        equipmentListSort = equipmentListSort!!
            .sortedBy { it.level }
            .take(pageSize * (page * 1))
            .drop(pageSize * (page - 1))
            .asReversed()
        return equipmentListSort!!.toList()
    }

    private fun deserialized(dir: String): List<Equipement> {
        return mapper.readValue(FileReader(dir))
    }
}