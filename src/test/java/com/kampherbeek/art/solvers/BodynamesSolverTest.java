package com.kampherbeek.art.solvers;

import com.kampherbeek.art.json.representation.BodynamesRequest;
import com.kampherbeek.art.json.representation.BodynamesResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BodynamesSolverTest {

    @Mock
    private BodynamesRequest requestMock = mock(BodynamesRequest.class);

    private BodynamesSolver solver;

    @Before
    public void setUp() throws Exception {
        solver = new BodynamesSolver();
    }

    @Test
    public void solveRequest() throws Exception {
        when(requestMock.getLocale()).thenReturn("en");
        BodynamesResponse result = solver.solveRequest(requestMock);
        assertTrue(result.getBodynames().size() > 0);
    }
}