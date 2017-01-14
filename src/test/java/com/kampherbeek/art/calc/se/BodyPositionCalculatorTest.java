package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.BodyPosition;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import swisseph.SwissEph;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BodyPositionCalculatorTest {

    @Mock
    private SwissEph swissEphMock = mock(SwissEph.class);
    private BodyPositionCalculator calculator;

    @Before
    public void setUp() throws Exception {
        when(swissEphMock.swe_calc_ut(anyDouble(), anyInt(), anyInt(), anyObject(), anyObject())).thenReturn(1);
        calculator = new BodyPositionCalculator();
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
    public void calcBody() throws Exception {
        calculator.setSwissEph(swissEphMock);
        BodyPosition bodyPosition = calculator.calcBody(3, 1234567.89, 1);
        assertNotNull(bodyPosition);
    }

    @Test(expected = RuntimeException.class)
    public void calcBodyWrongId() throws Exception {
        calculator.setSwissEph(swissEphMock);
        calculator.calcBody(987654, 1234567.89, 1);
    }
}
