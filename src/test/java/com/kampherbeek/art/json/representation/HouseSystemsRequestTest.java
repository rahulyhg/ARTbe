package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseSystemsRequestTest {

    private HouseSystemsRequest request;

    @Before
    public void setUp() throws Exception {
        request = new HouseSystemsRequest();
    }

    @Test
    public void setGetLocale() throws Exception {
        String locale = "nl";
        request.setLocale(locale);
        assertEquals(locale, request.getLocale());
    }

    @Test
    public void getDefaultLocale() throws Exception {
        String defaultLOcale = "en";
        assertEquals(defaultLOcale, request.getLocale());
    }
}