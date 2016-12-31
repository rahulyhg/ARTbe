package com.kampherbeek.art.domain;

import org.junit.Test;
import swisseph.SweConst;

import static org.junit.Assert.assertEquals;

public class CalculationFlagsTest {

    @Test
    public void getFlagId() throws Exception {
        assertEquals(SweConst.SEFLG_EQUATORIAL, CalculationFlags.EQUATORIAL.getFlagId());
    }
}