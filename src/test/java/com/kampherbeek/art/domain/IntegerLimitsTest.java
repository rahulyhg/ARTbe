package com.kampherbeek.art.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerLimitsTest {


    @Test
    public void getMinValue() throws Exception {
        assertEquals(0, IntegerLimits.MINUTE.getMinValue());
    }

    @Test
    public void getMaxValue() throws Exception {
        assertEquals(59, IntegerLimits.MINUTE.getMaxValue());
    }
}