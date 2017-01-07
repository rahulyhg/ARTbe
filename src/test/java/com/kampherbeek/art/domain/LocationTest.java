package com.kampherbeek.art.domain;

import org.junit.Before;
import org.junit.Test;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;

public class LocationTest {

    private final double latitude = 52.23;
    private final double longitude = 6.9;

    private Location location;

    @Before
    public void setUp() throws Exception {
        location = new Location(longitude, latitude);
    }

    @Test
    public void getLongitude() throws Exception {
        assertEquals(longitude, location.getLongitude(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getLatitude() throws Exception {
        assertEquals(latitude, location.getLatitude(), DOUBLE_MARGIN.getValue());
    }
}