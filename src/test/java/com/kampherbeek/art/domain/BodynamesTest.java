package com.kampherbeek.art.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BodynamesTest {

    @Test
    public void getSeId() throws Exception {
        assertEquals(0, Bodynames.SUN.getSeId());
    }

    @Test
    public void getInternalId() throws Exception {
        assertEquals(0, Bodynames.SUN.getInternalId());
    }

    @Test
    public void getRbKey() throws Exception {
        assertEquals("bodynames.sun", Bodynames.SUN.getRbKey());
    }
}