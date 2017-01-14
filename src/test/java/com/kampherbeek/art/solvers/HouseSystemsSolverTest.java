package com.kampherbeek.art.solvers;

import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import com.kampherbeek.art.json.representation.HouseSystemsResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HouseSystemsSolverTest {

    @Mock
    private HouseSystemsRequest requestMock = mock(HouseSystemsRequest.class);

    private HouseSystemsSolver solver;

    @Before
    public void setUp() throws Exception {
        solver = new HouseSystemsSolver();
    }

    @Test
    public void solveRequest() throws Exception {
        when(requestMock.getLocale()).thenReturn("en");
        HouseSystemsResponse result = solver.solveRequest(requestMock);
        assertTrue(result.getHouseSystems().size() > 0);
    }
}
