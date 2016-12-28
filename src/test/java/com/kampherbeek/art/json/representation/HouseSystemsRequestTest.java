package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseSystemsRequestTest {

    private String locale = "nl";
    private String defaultLOcale = "en";
    private HouseSystemsRequest request;

    @Before
    public void setUp() throws Exception {
        request = new HouseSystemsRequest();
    }

    @Test
    public void setGetLocale() throws Exception {
        request.setLocale(locale);
        assertEquals(locale, request.getLocale());
    }

    @Test
    public void getDefaultLocale() throws Exception {
        assertEquals(defaultLOcale, request.getLocale());
    }
}