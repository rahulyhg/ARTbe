package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.domain.SimpleDate;
import com.kampherbeek.art.domain.SimpleDateTime;
import com.kampherbeek.art.domain.SimpleTime;
import com.kampherbeek.art.json.representation.JdnrRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JdnrJsonConverterTest {

    private final String jsonRequest =
            "{\"simpleDateTime\":{\"simpleDate\":{\"year\":2016,\"month\":1,\"day\":2,\"gregorian\":true},\"simpleTime\":{\"hour\":20,\"minute\":41,\"second\":0}}}";

    private final int year = 2016;
    private final int month = 1;
    private final int day = 2;
    private final int hour = 20;
    private final int minute = 41;
    private final int second = 0;
    private final boolean isGregorian = true;

    private JdnrJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new JdnrJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        JdnrRequest request = converter.jsonRequest2Java(jsonRequest);
        SimpleDate simpleDate = request.getSimpleDateTime().getSimpleDate();
        SimpleTime simpleTime = request.getSimpleDateTime().getSimpleTime();
        assertEquals(year, simpleDate.getYear());
        assertEquals(month, simpleDate.getMonth());
        assertEquals(day, simpleDate.getDay());
        assertEquals(isGregorian, simpleDate.isGregorian());
        assertEquals(hour, simpleTime.getHour());
        assertEquals(minute, simpleTime.getMinute());
        assertEquals(second, simpleTime.getSecond());
    }


    // Convenience method to construct correct Json for request.
    @Test
    public void java2Json() throws Exception {
        JdnrRequest request = new JdnrRequest();
        SimpleDate simpleDate = new SimpleDate(year, month, day, isGregorian);
        SimpleTime simpleTime = new SimpleTime(hour, minute, second);
        SimpleDateTime simpleDateTime = new SimpleDateTime(simpleDate, simpleTime);
        request.setSimpleDateTime(simpleDateTime);
        String json = converter.java2JsonRequest(request);
        System.out.println(json);
        assertTrue(json.contains("year"));
    }


}
