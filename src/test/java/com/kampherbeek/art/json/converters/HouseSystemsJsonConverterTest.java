package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseSystemsJsonConverterTest {

    private HouseSystemsJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new HouseSystemsJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        String jsonRequest = "{\"locale\":\"en\"}";
        HouseSystemsRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals("en", request.getLocale());
    }
}
