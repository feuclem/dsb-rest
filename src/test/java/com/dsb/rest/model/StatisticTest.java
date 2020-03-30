package com.dsb.rest.model;

import org.junit.Assert;
import org.junit.Test;

public class StatisticTest {

    @Test
    public void hasForceTrue() {
        FromTo fromTo = new FromTo();
        fromTo.setFrom("1");
        fromTo.setTo("1");

        Statistic statistic = new Statistic();
        statistic.setForce(fromTo);
        Assert.assertEquals(statistic.hasForce(), true);
    }

    @Test
    public void hasForceFalse() {
        Statistic statistic = new Statistic();
        Assert.assertEquals(statistic.hasForce(), false);
    }
}