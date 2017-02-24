package com.kampherbeek.art.periods;

import com.kampherbeek.art.calc.se.SeFlags2IntCreator;
import com.kampherbeek.art.domain.*;
import com.kampherbeek.art.json.representation.BodyPositionResponse;
import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import com.kampherbeek.art.solvers.BodyPositionSolver;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PeriodValueDefinerTest {

    private final double margin = 0.000000001;
    private final double speedMain = 0.33;
    private final double coordinateMain = 123.45;
    private final double coordinateDistance = 3.3;
    private final double coordinateDeviation = -2.2;
    private BasePosition basePositionCoordinatesMock = mock(BasePosition.class);
    private BasePosition basePositionSpeedMock = mock(BasePosition.class);
    private BodyPositionSolver bodyPositionSolverMock = mock(BodyPositionSolver.class);
    private SeFlags2IntCreator seFlags2IntCreatorMock = mock(SeFlags2IntCreator.class);
    private SingleCyclesRequest requestMock = mock(SingleCyclesRequest.class);
    private CalculationPreferences calculationPreferencesMock = mock(CalculationPreferences.class);
    private BodyPositionResponse bodyPositionResponseMock = mock(BodyPositionResponse.class);
    private BodyPosition bodyPositionMock = mock(BodyPosition.class);
    private List<Double> allJdnrs;
    private PeriodValueDefiner periodValueDefiner;

    @Before
    public void setUp() throws Exception {
        allJdnrs = createListJdnrs();
        when(basePositionCoordinatesMock.getMainValue()).thenReturn(coordinateMain);
        when(basePositionCoordinatesMock.getDeviation()).thenReturn(coordinateDeviation);
        when(basePositionCoordinatesMock.getDistance()).thenReturn(coordinateDistance);
        when(basePositionSpeedMock.getMainValue()).thenReturn(speedMain);
//        when(basePositionSpeedMock.getDeviation()).thenReturn(0.11);
//        when(basePositionSpeedMock.getDistance()).thenReturn(0.01);
        when(bodyPositionMock.getCoordinates()).thenReturn(basePositionCoordinatesMock);
        when(bodyPositionMock.getSpeed()).thenReturn(basePositionSpeedMock);
        when(requestMock.getStartJdnr()).thenReturn(1234567.5);
        when(requestMock.getEndJdnr()).thenReturn(1234577.5);
        when(requestMock.getCalculationPreferences()).thenReturn(calculationPreferencesMock);
        when(requestMock.getLocale()).thenReturn("en");
        when(requestMock.getInternalId()).thenReturn(1);
        when(requestMock.getSingleCyclesMethod()).thenReturn(SingleCyclesMethod.SPEED);
        when(requestMock.getPeriodResultFormat()).thenReturn(PeriodResultFormat.JSON);
        when(bodyPositionResponseMock.getPosition()).thenReturn(bodyPositionMock);
        when(bodyPositionSolverMock.solveRequest(anyInt(), anyDouble(), anyInt())).thenReturn(bodyPositionResponseMock);
        periodValueDefiner = new PeriodValueDefiner(bodyPositionSolverMock, seFlags2IntCreatorMock);
    }

    @Test
    public void defineValuesSpeed() throws Exception {
        List<Double[]> result = periodValueDefiner.defineValues(allJdnrs, requestMock);
        assertEquals(speedMain, result.get(0)[1], margin);

    }

    @Test
    public void defineValuesDistance() throws Exception {
        when(requestMock.getSingleCyclesMethod()).thenReturn(SingleCyclesMethod.DISTANCE);
        List<Double[]> result = periodValueDefiner.defineValues(allJdnrs, requestMock);
        assertEquals(coordinateDistance, result.get(0)[1], margin);

    }

    @Test
    public void defineValuesPosition() throws Exception {
        when(requestMock.getSingleCyclesMethod()).thenReturn(SingleCyclesMethod.POSITION);
        List<Double[]> result = periodValueDefiner.defineValues(allJdnrs, requestMock);
        assertEquals(coordinateMain, result.get(0)[1], margin);

    }

    @Test
    public void defineValuesDeviation() throws Exception {
        when(requestMock.getSingleCyclesMethod()).thenReturn(SingleCyclesMethod.DEVIATION);
        List<Double[]> result = periodValueDefiner.defineValues(allJdnrs, requestMock);
        assertEquals(coordinateDeviation, result.get(0)[1], margin);

    }

    private List<Double> createListJdnrs() {
        List<Double> allJdnrs = new ArrayList<>();
        allJdnrs.add(234567.8);
        allJdnrs.add(234568.8);
        return allJdnrs;
    }
}