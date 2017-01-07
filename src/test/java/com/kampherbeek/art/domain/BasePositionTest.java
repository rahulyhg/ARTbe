package com.kampherbeek.art.domain;

import org.junit.Before;
import org.junit.Test;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;

public class BasePositionTest {

    private final double longitude = 123.45;
    private final double latitude = -2.2;
    private final double distance = 13.4567;
    private BasePosition basePosition;

    @Before
    public void setUp() throws Exception {
        basePosition = new BasePosition(longitude, latitude, distance);
    }

    @Test
    public void getMainValue() throws Exception {
        assertEquals(longitude, basePosition.getMainValue(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getDeviation() throws Exception {
        assertEquals(latitude, basePosition.getDeviation(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getDistance() throws Exception {
        assertEquals(distance, basePosition.getDistance(), DOUBLE_MARGIN.getValue());
    }
}