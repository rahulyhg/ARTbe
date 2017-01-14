package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.HousePositions;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SEFrontendTest {

    @Mock
    private BodyPositionCalculator bodyCalculatorMock = mock(BodyPositionCalculator.class);
    @Mock
    private BodyPosition bodyPosMock = mock(BodyPosition.class);
    @Mock
    private BodyPositionRequest bodyReqMock = mock(BodyPositionRequest.class);
    @Mock
    private HousePositionsCalculator housesCalculatorMock = mock(HousePositionsCalculator.class);
    @Mock
    private HousePositions housesPosMock = mock(HousePositions.class);
    @Mock
    private HousePositionsRequest housesReqMock = mock(HousePositionsRequest.class);

    private SEFrontend seFrontend;

    @Before
    public void setUp() throws Exception {
        when(bodyCalculatorMock.calcBody(anyInt(), anyDouble(), anyInt())).thenReturn(bodyPosMock);
        when(housesCalculatorMock.calcHouses(anyInt(), anyObject(), anyDouble(), anyInt())).thenReturn(housesPosMock);
        seFrontend = new SEFrontend(housesCalculatorMock, bodyCalculatorMock);
    }

    @Test
    public void calcHouses() throws Exception {
        HousePositions housesPositions = seFrontend.calcHouses(housesReqMock);
        assertEquals(housesPosMock, housesPositions);
    }

    @Test
    public void calcBody() throws Exception {
        BodyPosition bodyPosition = seFrontend.calcBody(bodyReqMock);
        assertEquals(bodyPosMock, bodyPosition);
    }
}