package com.kampherbeek.art.solvers;

import com.kampherbeek.art.calc.se.SEFrontend;
import com.kampherbeek.art.domain.BasePosition;
import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.json.representation.EpsilonRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EpsilonSolverTest {

    @Mock
    private BasePosition basePositionMock = mock(BasePosition.class);
    @Mock
    private BodyPosition positionMock = mock(BodyPosition.class);
    @Mock
    private EpsilonRequest requestMock = mock(EpsilonRequest.class);
    @Mock
    private SEFrontend seFrontendMock = mock(SEFrontend.class);
    private EpsilonSolver solver;

    @Before
    public void setUp() throws Exception {
        double epsilon = 23.447;
        when(basePositionMock.getMainValue()).thenReturn(epsilon);
        when(positionMock.getCoordinates()).thenReturn(basePositionMock);
        when(seFrontendMock.calcBody(anyObject())).thenReturn(positionMock);
        solver = new EpsilonSolver(seFrontendMock);
    }

    @Test
    public void solveRequest() throws Exception {

        assertEquals(positionMock.getCoordinates().getMainValue(), solver.solveRequest(requestMock).getEpsilon(),
                DOUBLE_MARGIN.getValue());
    }
}
