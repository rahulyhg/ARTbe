package com.kampherbeek.art.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LimitsTest {

    private final double margin = 0.000000001;

    @Test
    public void getValue() throws Exception {
        assertEquals(180.0, Limits.MAX_LONGITUDE.getValue(), margin);
    }
}