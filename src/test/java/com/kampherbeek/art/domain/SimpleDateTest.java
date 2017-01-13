package com.kampherbeek.art.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleDateTest {

    private final int year = 2017;
    private final int month = 1;
    private final int day = 8;
    private final boolean gregorian = true;
    private SimpleDate simpleDate;

    @Before
    public void setUp() throws Exception {
        simpleDate = new SimpleDate(year, month, day, gregorian);
    }

    @Test
    public void getYear() throws Exception {
        assertEquals(year, simpleDate.getYear());
    }

    @Test
    public void getMonth() throws Exception {
        assertEquals(month, simpleDate.getMonth());
    }

    @Test
    public void getDay() throws Exception {
        assertEquals(day, simpleDate.getDay());
    }

    @Test
    public void isGregorian() throws Exception {
        assertEquals(gregorian, simpleDate.isGregorian());
    }
}