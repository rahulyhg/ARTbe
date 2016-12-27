package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseSystemsJsonConverterTest {

    private final String jsonRequest = "{\"locale\":\"en\"}";
    private HouseSystemsJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new HouseSystemsJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        HouseSystemsRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals("en", request.getLocale());
    }
}
