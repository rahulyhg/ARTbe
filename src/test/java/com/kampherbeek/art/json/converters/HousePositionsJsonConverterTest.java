package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.domain.HouseSystems;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HousePositionsJsonConverterTest {

    private final double jdnr = 2457139.8;
    private final double longitude = 6.9;
    private final double latitude = 52.23;
    private final double margin = 0.000000001;
    private final String jsonRequest =
            "{\"system\":\"ALCABITIUS\",\"jdnr\":2457139.8,\"location\":{\"longitude\":6.9,\"latitude\":52.23}}";
    private HousePositionsJsonConverter converter;


    @Before
    public void setUp() throws Exception {
        converter = new HousePositionsJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        HousePositionsRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals(jdnr, request.getJdnr(), margin);
        assertEquals(longitude, request.getLocation().getLongitude(),margin);
        assertEquals(latitude, request.getLocation().getLatitude(), margin);
        assertEquals(HouseSystems.ALCABITIUS, request.getSystem());
    }
}

