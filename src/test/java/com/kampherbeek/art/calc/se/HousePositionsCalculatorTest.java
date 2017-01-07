package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.HousePositions;
import com.kampherbeek.art.domain.Location;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import swisseph.SwissEph;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HousePositionsCalculatorTest {

    @Mock
    private Location locationMock = mock(Location.class);
    @Mock
    private SwissEph swissEphMock = mock(SwissEph.class);

    private HousePositionsCalculator calculator;

    @Before
    public void setUp() throws Exception {
        when(swissEphMock.swe_calc_ut(anyDouble(), anyInt(), anyInt(), anyObject(), anyObject())).thenReturn(1);
        calculator = new HousePositionsCalculator();
    }

    @Test
    public void setSwissEph() throws Exception {
        try {
            calculator.setSwissEph(swissEphMock);
            assertTrue("No exception thrown", true);
        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void calcHouses() throws Exception {
        calculator.setSwissEph(swissEphMock);
        HousePositions positions = calculator.calcHouses(2, locationMock, 1234567.89, 1);
        assertNotNull(positions);
    }

    @Test (expected = RuntimeException.class)
    public void calcHousesWrongId() throws Exception {
        calculator.setSwissEph(swissEphMock);
        calculator.calcHouses(34567, locationMock, 1234567.89, 1);
    }

    @Test (expected = RuntimeException.class)
    public void calcHousesSwissEphNull() throws Exception {
        calculator.setSwissEph(null);
        calculator.calcHouses(2, locationMock, 1234567.89, 1);
    }
}
