package com.kampherbeek.art.periods;

import com.kampherbeek.art.calc.se.SeFlags2IntCreator;
import com.kampherbeek.art.domain.*;
import com.kampherbeek.art.json.representation.BodyPositionResponse;
import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import com.kampherbeek.art.solvers.BodyPositionSolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PeriodParserTest {

    @Mock
    private final BodyPositionSolver bodyPositionSolverMock = mock(BodyPositionSolver.class);
    private final BodyPosition bodyPositionMock = mock(BodyPosition.class);
    private final BasePosition basePositionMock = mock(BasePosition.class);
    private final SeFlags2IntCreator seFlags2IntCreatorMock = mock(SeFlags2IntCreator.class);
    private final SpeedPeriodComparator comparatorMock = mock(SpeedPeriodComparator.class);
    private final BodyPositionResponse bodyPositionResponseMock = mock(BodyPositionResponse.class);
    private final SingleCyclesRequest requestMock = mock(SingleCyclesRequest.class);
    private final CalculationPreferences calculationPreferencesMock = mock(CalculationPreferences.class);

    private PeriodParser parser;

    @Before
    public void setUp() throws Exception {
        when(basePositionMock.getMainValue()).thenReturn(1.0);
        when(bodyPositionMock.getSpeed()).thenReturn(basePositionMock);
        when(bodyPositionResponseMock.getPosition()).thenReturn(bodyPositionMock);
        when(bodyPositionResponseMock.getBodyname()).thenReturn(Bodynames.MARS);
        when(bodyPositionSolverMock.solveRequest(anyInt(), anyDouble(), anyInt())).thenReturn(bodyPositionResponseMock);
        when(seFlags2IntCreatorMock.createFlags(anyObject())).thenReturn(258);
        when(comparatorMock.defineResults(anyObject())).thenReturn(SpeedResults.NONE);
        when(calculationPreferencesMock.getFlags()).thenReturn(createFlags());
        when(requestMock.getCalculationPreferences()).thenReturn(calculationPreferencesMock);
        when(requestMock.getInternalId()).thenReturn(4);
        when(requestMock.getSingleCyclesMethod()).thenReturn(SingleCyclesMethod.SPEED);
        when(requestMock.getPeriodResultFormat()).thenReturn(PeriodResultFormat.SCREEN);
        when(requestMock.getStartJdnr()).thenReturn(2000000.0);
        when(requestMock.getEndJdnr()).thenReturn(2000100.0);
        parser = new PeriodParser(bodyPositionSolverMock, seFlags2IntCreatorMock, comparatorMock);
    }

    @Test
    public void lookForOccurrences() throws Exception {
        try {
            parser.lookForOccurrences(requestMock);
            assertTrue("No exception occurred", true);
        } catch (Exception e) {
            fail("An unexpected excewption occurred : " + e.getMessage());
        }
    }

    private List<CalculationFlags> createFlags() {
        List<CalculationFlags> flags = new ArrayList<>();
        flags.add(CalculationFlags.SWIEPH);
        flags.add(CalculationFlags.SPEED);
        return flags;
    }
}