package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BodynamesRequestTest {

    private BodynamesRequest request;

    @Before
    public void setUp() throws Exception {
        request = new BodynamesRequest();
    }

    @Test
    public void setGetLocale() throws Exception {
        String locale = "nl";
        request.setLocale(locale);
        assertEquals(locale, request.getLocale());
    }

    @Test
    public void getDefaultLocale() throws Exception {
        String defaultLocale = "en";
        assertEquals(defaultLocale, request.getLocale());
    }
}

