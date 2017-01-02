package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JdnrRequestTest {

    private final int year = 2016;
    private final int month = 1;
    private final int day = 2;
    private final int hours = 20;
    private final int minutes = 41;
    private final int seconds = 0;
    private final boolean isGregorian = true;
    private JdnrRequest request;

    @Before
    public void setUp() throws Exception {
        request = new JdnrRequest();
    }

    @Test
    public void getSetYear() throws Exception {
        request.setYear(year);
        assertEquals(year, request.getYear());
    }

    @Test
    public void getMonth() throws Exception {
        request.setMonth(month);
        assertEquals(month, request.getMonth());
    }

    @Test
    public void getDay() throws Exception {
        request.setDay(day);
        assertEquals(day, request.getDay());
    }

    @Test
    public void getHours() throws Exception {
        request.setHours(hours);
        assertEquals(hours, request.getHours());
    }

    @Test
    public void getMinutes() throws Exception {
        request.setMinutes(minutes);
        assertEquals(minutes, request.getMinutes());
    }

    @Test
    public void getSeconds() throws Exception {
        request.setSeconds(seconds);
        assertEquals(seconds, request.getSeconds());
    }

    @Test
    public void isGregorian() throws Exception {
        request.setGregorian(isGregorian);
        assertEquals(isGregorian, request.isGregorian());
    }
}