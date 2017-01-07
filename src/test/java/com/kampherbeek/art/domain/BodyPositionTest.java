package com.kampherbeek.art.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BodyPositionTest {

    @Mock
    private BasePosition coordinatesMock = mock(BasePosition.class);
    @Mock
    private BasePosition speedMock = mock(BasePosition.class);
    private BodyPosition bodyPosition;
    private final Bodynames bodyname = Bodynames.JUPITER;



    @Before
    public void setUp() throws Exception {
        bodyPosition = new BodyPosition(bodyname, coordinatesMock, speedMock);
    }

    @Test
    public void getBodyname() throws Exception {
        assertEquals(bodyname, bodyPosition.getBodyname());
    }

    @Test
    public void getCoordinates() throws Exception {
        assertEquals(coordinatesMock, bodyPosition.getCoordinates());
    }

    @Test
    public void getSpeed() throws Exception {
        assertEquals(speedMock, bodyPosition.getSpeed());
    }
}