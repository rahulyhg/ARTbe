package com.kampherbeek.art.solvers;

import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import com.kampherbeek.art.util.PropertiesReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VersionSolverTest {

    @Mock
    private PropertiesReader readerMock = mock(PropertiesReader.class);
    @Mock
    private VersionRequest requestMock = mock(VersionRequest.class);
    private final String fullType = "full";
    private final String shortType = "short";
    private final String wrongType = "X";
    private VersionSolver solver;

    @Before
    public void setUp() throws Exception {
        when(readerMock.getValueForProperty(anyString())).thenReturn(fullType);
        solver = new VersionSolver(readerMock);
    }

    @Test
    public void solveRequest() throws Exception {
        when(requestMock.getVersionType()).thenReturn(fullType);
        VersionResponse response = solver.solveRequest(requestMock);
        assertEquals(fullType, response.getVersionType());
    }

    @Test
    public void solveRequestDefault() throws Exception {
        when(requestMock.getVersionType()).thenReturn(wrongType);
        VersionResponse response = solver.solveRequest(requestMock);
        assertEquals(shortType, response.getVersionType());
    }

}