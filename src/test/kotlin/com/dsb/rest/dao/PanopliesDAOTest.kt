package com.dsb.rest.dao

import org.junit.Assert
import org.junit.Test
import java.io.IOException

class PanopliesDAOTest {
    private val panopliesDAO = PanopliesDAO()

    @Test
    fun testGetAllPanoplie() {
        // When
        val panoplies = panopliesDAO.getAllPanoplies()

        // Then
        Assert.assertEquals(panoplies.size, 331)
    }

    @Test
    fun testGetStatsOfPanoplieBonus() {
        // When
        val stats = panopliesDAO.getStatsOfPanoplieBonus(274, 2)

        // Then
        Assert.assertEquals(stats[0].vitalite!!.min, "100")
        Assert.assertEquals(stats[0].vitalite!!.max, "100")
    }
}