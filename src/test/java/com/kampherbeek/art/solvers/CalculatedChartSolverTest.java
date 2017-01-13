package com.kampherbeek.art.solvers;

import com.kampherbeek.art.json.representation.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatedChartSolverTest {

    @Mock
    private JdnrSolver jdnrSolverMock = mock(JdnrSolver.class);
    @Mock
    private BodySetPositionSolver bodySetPositionSolverMock = mock(BodySetPositionSolver.class);
    @Mock
    private HousePositionsSolver housePositionsSolverMock = mock(HousePositionsSolver.class);
    @Mock
    private CalculatedChartRequest requestMock = mock(CalculatedChartRequest.class);
    @Mock
    private BodySetPositionResponse bodySetPositionResponseMock = mock(BodySetPositionResponse.class);
    @Mock
    private HousePositionsResponse housePositionsResponseMock = mock(HousePositionsResponse.class);
    @Mock
    private JdnrResponse jdnrResponseMock = mock(JdnrResponse.class);
    private final double jdnr = 1234567.89;

    private CalculatedChartSolver solver;

    @Before
    public void setUp() throws Exception {
        when(jdnrResponseMock.getJdnr()).thenReturn(jdnr);
        when(jdnrSolverMock.solveRequest(anyObject())).thenReturn(jdnrResponseMock);
        when(bodySetPositionSolverMock.solveRequest(anyObject())).thenReturn(bodySetPositionResponseMock);
        when(housePositionsSolverMock.solveRequest(anyObject())).thenReturn(housePositionsResponseMock);
        solver = new CalculatedChartSolver(jdnrSolverMock, bodySetPositionSolverMock, housePositionsSolverMock);
    }

    @Test
    public void solveRequest() throws Exception {
        assertEquals(bodySetPositionResponseMock, solver.solveRequest(requestMock).getBodySetPositionResponse());
        assertEquals(housePositionsResponseMock, solver.solveRequest(requestMock).getHousePositionsResponse());
    }
}
