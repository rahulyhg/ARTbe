package com.kampherbeek.art.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleTimeTest {

    private final int hour = 20;
    private final int minute = 21;
    private final int second = 22;
    private SimpleTime simpleTime;

    @Before
    public void setUp() throws Exception {
        simpleTime = new SimpleTime(hour, minute, second);
    }

    @Test
    public void getHour() throws Exception {
        assertEquals(hour, simpleTime.getHour());
    }

    @Test
    public void getMinute() throws Exception {
        assertEquals(minute, simpleTime.getMinute());
    }

    @Test
    public void getSecond() throws Exception {
        assertEquals(second, simpleTime.getSecond());
    }
}