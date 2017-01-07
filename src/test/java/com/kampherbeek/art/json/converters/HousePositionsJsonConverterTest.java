package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.HousePositionsRequest;
import org.junit.Before;
import org.junit.Test;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;

public class HousePositionsJsonConverterTest {

    private final double jdnr = 2457139.8;
    private final double longitude = 6.9;
    private final double latitude = 52.23;
    private final String jsonRequest =
            "{\"system\":4,\"jdnr\":2457139.8,\"location\":{\"longitude\":6.9,\"latitude\":52.23}}";
    private HousePositionsJsonConverter converter;


    @Before
    public void setUp() throws Exception {
        converter = new HousePositionsJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        HousePositionsRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals(jdnr, request.getJdnr(), DOUBLE_MARGIN.getValue());
        assertEquals(longitude, request.getLocation().getLongitude(), DOUBLE_MARGIN.getValue());
        assertEquals(latitude, request.getLocation().getLatitude(), DOUBLE_MARGIN.getValue());
        assertEquals(4, request.getSystem());
    }
}

