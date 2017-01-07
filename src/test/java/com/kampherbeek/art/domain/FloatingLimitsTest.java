package com.kampherbeek.art.domain;

import org.junit.Test;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;

public class FloatingLimitsTest {



    @Test
    public void getMaxValue() throws Exception {
        assertEquals(180.0, FloatingLimits.LONGITUDE.getMaxValue(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getMinValue() throws Exception {
        assertEquals(-180.0, FloatingLimits.LONGITUDE.getMinValue(), DOUBLE_MARGIN.getValue());
    }

}