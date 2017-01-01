package com.kampherbeek.art.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloatingLimitsTest {

    private final double margin = 0.000000001;

    @Test
    public void getValue() throws Exception {
        assertEquals(180.0, FloatingLimits.MAX_LONGITUDE.getValue(), margin);
    }
}