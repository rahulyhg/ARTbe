package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.HousePositionsRequest;
import org.junit.Before;
import org.junit.Test;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;

public class HousePositionsJsonConverterTest {

    private HousePositionsJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new HousePositionsJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        String jsonRequest = "{\"system\":4,\"jdnr\":2457139.8,\"location\":{\"longitude\":6.9,\"latitude\":52.23}}";
        HousePositionsRequest request = converter.jsonRequest2Java(jsonRequest);
        double jdnr = 2457139.8;
        assertEquals(jdnr, request.getJdnr(), DOUBLE_MARGIN.getValue());
        double longitude = 6.9;
        assertEquals(longitude, request.getLocation().getLongitude(), DOUBLE_MARGIN.getValue());
        double latitude = 52.23;
        assertEquals(latitude, request.getLocation().getLatitude(), DOUBLE_MARGIN.getValue());
        assertEquals(4, request.getSystem());
    }
}

