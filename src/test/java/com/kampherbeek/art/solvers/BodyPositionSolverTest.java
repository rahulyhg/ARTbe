package com.kampherbeek.art.solvers;

import com.kampherbeek.art.calc.se.SEFrontend;
import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BodyPositionSolverTest {

    @Mock
    private BodyPositionRequest requestMock = mock(BodyPositionRequest.class);
    @Mock
    private SEFrontend seFrontendMock = mock(SEFrontend.class);
    @Mock
    private BodyPosition bodyPositionMock = mock(BodyPosition.class);
    private BodyPositionSolver solver;

    @Before
    public void setUp() throws Exception {
        when(seFrontendMock.calcBody(anyObject())).thenReturn(bodyPositionMock);
        solver = new BodyPositionSolver(seFrontendMock);
    }

    @Test
    public void solveRequest() throws Exception {
        assertEquals(bodyPositionMock, solver.solveRequest(requestMock).getPosition());
    }

    @Test (expected = RuntimeException.class)
    public void solveRequestWrongBody() throws Exception {
        when (requestMock.getInternalId()).thenReturn(-999);
        solver.solveRequest(requestMock);
    }
}
