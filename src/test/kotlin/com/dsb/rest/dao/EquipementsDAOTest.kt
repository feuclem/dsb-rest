package com.dsb.rest.dao

import org.junit.Assert
import org.junit.Test
import java.io.IOException
import java.util.Arrays

class EquipementsDAOTest {
    private val amulettesController = EquipementsDAO()
    private val dir = "src/main/resources/equipements/amulettes.json"

    // Given
    @Test
    fun allEquipementsTest() {
        // Given
        val page = 1

        // When
        val result = amulettesController.getAllEquipements(dir, page)

        // Then
        Assert.assertEquals(result.size.toLong(), 50)
        Assert.assertEquals(result[0].name, "Collier Lunaire")
    }

    @Test
    fun filterByLevel() {
        // When
        val result = amulettesController.filterEquipementsByLevel(dir, 1, 200)

        // Then
        Assert.assertEquals(result.size.toLong(), 37)
        Assert.assertEquals(result[0].name, "Amulette Séculaire")
    }

    @Test
    fun filterByLevelShould() {
        // When
        val result = amulettesController.filterEquipementsByLevel(dir, 1, 200)

        // Then
        Assert.assertEquals(result.size.toLong(), 37)
        Assert.assertEquals(result[0].name, "Amulette Séculaire")
    }

    @Test
    fun filterByName() {
        // When
        val result = amulettesController.filterEquipementsByName(dir, 1, 200, "hibou")

        // Then
        Assert.assertEquals(result.size.toLong(), 2)
        Assert.assertEquals(result[0].name, "Pendentif du Hibou Chétif")
        Assert.assertEquals(result[1].name, "Amulette du Hibou")
    }

    @Test
    fun filterForStatsAddingFilter() {
        // When
        val result = amulettesController.filter(dir, 1, 200, null, Arrays.asList("Force"))

        // Then
        Assert.assertEquals(result.size.toLong(), 50)

        // When
        val result2 = amulettesController.filter(dir, 1, 200, null, Arrays.asList("Force", "Agilite"))

        // Then
        Assert.assertEquals(result2.size.toLong(), 20)
    }

    @Test
    fun filterForStatsRemovingFilter() {
        // Given
        amulettesController.filter(dir, 1, 200, null, Arrays.asList("Force"))

        // When
        val result = amulettesController.filter(dir, 1, 200, null, Arrays.asList("Force", "Agilite"))

        // Then
        Assert.assertEquals(result.size.toLong(), 20)

        // When
        val result2 = amulettesController.filter(dir, 1, 200, null, Arrays.asList("Agilite"))

        // Then
        Assert.assertEquals(result2.size.toLong(), 50)

        // When
        val result3 = amulettesController.filter(dir, 1, 200, null, Arrays.asList("Agilite", "Chance"))

        // Then
        Assert.assertEquals(result3.size.toLong(), 19)
    }
}