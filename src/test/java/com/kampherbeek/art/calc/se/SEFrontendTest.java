package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.CalculationFlags;
import com.kampherbeek.art.domain.CalculationPreferences;
import com.kampherbeek.art.domain.HousePositions;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

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
    @Mock
    private SeFlags2IntCreator seFlags2IntCreatorMock = mock(SeFlags2IntCreator.class);
    @Mock
    private CalculationPreferences preferencesMock = mock(CalculationPreferences.class);

    private SEFrontend seFrontend;

    @Before
    public void setUp() throws Exception {
        List<CalculationFlags> flags = constructFlags();
        when(preferencesMock.getFlags()).thenReturn(flags);
        when(housesReqMock.getCalculationPreferences()).thenReturn(preferencesMock);
        when(bodyReqMock.getCalculationPreferences()).thenReturn(preferencesMock);
        when(bodyCalculatorMock.calcBody(anyInt(), anyDouble(), anyInt())).thenReturn(bodyPosMock);
        when(housesCalculatorMock.calcHouses(anyInt(), anyObject(), anyDouble(), anyInt())).thenReturn(housesPosMock);
        seFrontend = new SEFrontend(housesCalculatorMock, bodyCalculatorMock, seFlags2IntCreatorMock);
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


    @Test
    public void calcBodyWithSeparateParams() throws Exception {
        int internalId = 1;
        double jdnr = 12345678.5;
        int flags = 1;
        BodyPosition bodyPosition = seFrontend.calcBody(internalId, jdnr, flags);
        assertEquals(bodyPosMock, bodyPosition);
    }

    private List<CalculationFlags> constructFlags() {
        List<CalculationFlags> flags = new ArrayList<>();
        flags.add(CalculationFlags.EQUATORIAL);
        return flags;
    }
}

