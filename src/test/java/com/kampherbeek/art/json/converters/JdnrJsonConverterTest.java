package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.JdnrRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JdnrJsonConverterTest {

    private final String jsonRequest =
            "{\"year\":2016,\"month\":1,\"day\":2,\"hours\":20,\"minutes\":41,\"seconds\":0,\"gregorian\":true}";
    private final int year = 2016;
    private final int month = 1;
    private final int day = 2;
    private final int hours = 20;
    private final int minutes = 41;
    private final int seconds = 0;
    private final boolean isGregorian = true;

    private JdnrJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new JdnrJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        JdnrRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals(year, request.getYear());
        assertEquals(month, request.getMonth());
        assertEquals(day, request.getDay());
        assertEquals(hours, request.getHours());
        assertEquals(minutes, request.getMinutes());
        assertEquals(seconds, request.getSeconds());
        assertEquals(isGregorian, request.isGregorian());
    }


    // Convenience method to construct correct Json for request.
    @Test
    public void java2Json() throws Exception {
        JdnrRequest request = new JdnrRequest();
        request.setYear(year);
        request.setMonth(month);
        request.setDay(day);
        request.setHours(hours);
        request.setMinutes(minutes);
        request.setSeconds(seconds);
        request.setGregorian(isGregorian);
        String json = converter.java2JsonRequest(request);
        assertTrue(json.contains("year"));
    }


}
