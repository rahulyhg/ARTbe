package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.BodynamesRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BodynamesJsonConverterTest {

    private final String jsonRequest = "{\"locale\":\"en\"}";
    private BodynamesJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new BodynamesJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        BodynamesRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals("en", request.getLocale());
    }
}
