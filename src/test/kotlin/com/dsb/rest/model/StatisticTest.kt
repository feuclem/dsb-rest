package com.dsb.rest.model

import org.junit.Assert
import org.junit.Test

class StatisticTest {
    @Test
    fun hasForceTrue() {
        val fromTo = FromTo()
        fromTo.min = "1"
        fromTo.max = "1"
        val statistic = Statistic()
        statistic.force = fromTo
        Assert.assertEquals(statistic.hasForce(), true)
    }

    @Test
    fun hasForceFalse() {
        val statistic = Statistic()
        Assert.assertEquals(statistic.hasForce(), false)
    }
}