package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.converters.NoParamJsonConverter;
import com.kampherbeek.art.json.representation.EphemerisFilesResponse;
import com.kampherbeek.art.solvers.EphemerisFilesSolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EphemerisFilesHandlerTest {

    @Mock
    private NoParamJsonConverter converterMock = mock(NoParamJsonConverter.class);
    @Mock
    private EphemerisFilesSolver efSolverMock = mock(EphemerisFilesSolver.class);
    @Mock
    private EphemerisFilesResponse responseMock = mock(EphemerisFilesResponse.class);

    private final String resultHappyFlowTxt = "myResultHF";
    private final String resultExceptionTxt = "Error in EphemerisFilesHandler";
    private EphemerisFilesHandler handler;

    @Before
    public void setUp() throws Exception {
        when(efSolverMock.solveRequest()).thenReturn(responseMock);
        when(converterMock.java2JsonResponse(anyObject())).thenReturn(resultHappyFlowTxt);
        handler = new EphemerisFilesHandler(converterMock, efSolverMock);
    }

    @Test
    public void handleRequest() throws Exception {
        assertEquals(resultHappyFlowTxt, handler.handleRequest());
    }

    @Test
    public void handleRequestException() throws Exception {
        when(converterMock.java2JsonResponse(anyObject())).thenThrow(JsonProcessingException.class);
        assertEquals(resultExceptionTxt, handler.handleRequest());
    }
}

