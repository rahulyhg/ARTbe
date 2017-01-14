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

    private final String fullType = "full";
    @Mock
    private PropertiesReader readerMock = mock(PropertiesReader.class);
    @Mock
    private VersionRequest requestMock = mock(VersionRequest.class);
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
        String wrongType = "X";
        when(requestMock.getVersionType()).thenReturn(wrongType);
        VersionResponse response = solver.solveRequest(requestMock);
        String shortType = "short";
        assertEquals(shortType, response.getVersionType());
    }
}