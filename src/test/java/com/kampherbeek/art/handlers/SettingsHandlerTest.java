package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.converters.NoParamJsonConverter;
import com.kampherbeek.art.json.representation.SettingsResponse;
import com.kampherbeek.art.solvers.SettingsSolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SettingsHandlerTest {

    @Mock
    private NoParamJsonConverter jsonConverterMock = mock(NoParamJsonConverter.class);
    @Mock
    private SettingsSolver solverMock = mock(SettingsSolver.class);
    @Mock
    private SettingsResponse responseMock = mock(SettingsResponse.class);

    private final String resultHappyFlowTxt = "myResultHF";
    private final String resultExceptionTxt = "Error in SettingsHandler";
    private SettingsHandler handler;

    @Before
    public void setUp() throws Exception {
        when(solverMock.solveRequest()).thenReturn(responseMock);
        when(jsonConverterMock.java2JsonResponse(anyObject())).thenReturn(resultHappyFlowTxt);
        handler = new SettingsHandler(jsonConverterMock, solverMock);
    }

    @Test
    public void handleRequest() throws Exception {
        assertEquals(resultHappyFlowTxt, handler.handleRequest());
    }

    @Test
    public void handleRequestException() throws Exception {
        when(jsonConverterMock.java2JsonResponse(anyObject())).thenThrow(JsonProcessingException.class);
        assertEquals(resultExceptionTxt, handler.handleRequest());
    }

}
