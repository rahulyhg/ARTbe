package com.kampherbeek.art.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseSystemsTest {

    @Test
    public void getSeId() throws Exception {
        assertEquals('Y', HouseSystems.APC.getSeId());
    }

    @Test
    public void getId() throws Exception {
        assertEquals(16, HouseSystems.APC.getInternalId());
    }

    @Test
    public void getNrOfCusps() throws Exception {
        assertEquals(12, HouseSystems.APC.getNrOfCusps());
    }

    @Test
    public void getRbKey() throws Exception {
        assertEquals("housesystems.apc", HouseSystems.APC.getRbKey());
    }
}