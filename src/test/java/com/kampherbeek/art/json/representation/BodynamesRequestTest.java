package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BodynamesRequestTest {

    private final String locale = "nl";
    private final String defaultLocale = "en";
    private BodynamesRequest request;

    @Before
    public void setUp() throws Exception {
        request = new BodynamesRequest();
    }

    @Test
    public void setGetLocale() throws Exception {
        request.setLocale(locale);
        assertEquals(locale, request.getLocale());
    }

    @Test
    public void getDefaultLocale() throws Exception {
        assertEquals(defaultLocale, request.getLocale());
    }
}

