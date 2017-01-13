package com.kampherbeek.art.solvers;

import com.kampherbeek.art.calc.se.SEFrontend;
import com.kampherbeek.art.domain.HousePositions;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HousePositionsSolverTest {

    @Mock
    private HousePositionsRequest requestMock = mock(HousePositionsRequest.class);
    @Mock
    private SEFrontend seFrontendMock = mock(SEFrontend.class);
    @Mock
    private HousePositions housePositionsMock = mock(HousePositions.class);
    private HousePositionsSolver solver;



    @Before
    public void setUp() throws Exception {
        when(seFrontendMock.calcHouses(anyObject())).thenReturn(housePositionsMock);
        solver = new HousePositionsSolver(seFrontendMock);
    }

    @Test
    public void solveRequest() throws Exception {
        assertEquals(housePositionsMock, solver.solveRequest(requestMock).getPositions());
    }
}