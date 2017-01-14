package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.CalculatedChartJsonConverter;
import com.kampherbeek.art.json.representation.CalculatedChartRequest;
import com.kampherbeek.art.json.validators.CalculatedChartValidator;
import com.kampherbeek.art.solvers.CalculatedChartSolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatedChartHandlerTest {

    private final String jsonRequest = "{\"simpleDateTime\":{\"simpleDate\":{\"year\":2002,\"month\":3,\"day\":15,\"gregorian\":true},\"simpleTime\":{\"hour\":13,\"minute\":54,\"second\":43}},\"location\":{\"longitude\":18.17,\"latitude\":55.44},\"flagValue\":258,\"houseSystemId\":12,\"bodyIds\":[0,1]}\n";
    private final String correctResponse = "{\"dummy4correct\":\"response\"}";
    @Mock
    private CalculatedChartValidator validatorMock = mock(CalculatedChartValidator.class);
    @Mock
    private CalculatedChartJsonConverter converterMock = mock(CalculatedChartJsonConverter.class);
    @Mock
    private CalculatedChartSolver solverMock = mock(CalculatedChartSolver.class);
    @Mock
    private ValidatedObject validatedObjectMock = mock(ValidatedObject.class);
    @Mock
    private CalculatedChartRequest requestMock = mock(CalculatedChartRequest.class);
    private CalculatedChartHandler handler;

    @Before
    public void setUp() throws Exception {

        when(validatedObjectMock.isValid()).thenReturn(true);
        when(validatedObjectMock.getObject()).thenReturn(requestMock);
        when(validatorMock.handleJson(anyString(), anyObject())).thenReturn(validatedObjectMock);
        when(converterMock.java2JsonResponse(anyObject())).thenReturn(correctResponse);
        handler = new CalculatedChartHandler(validatorMock, converterMock, solverMock);
    }

    @Test
    public void handleRequest() throws Exception {
        String result = handler.handleRequest(jsonRequest);
        assertEquals(correctResponse, result);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void handleRequestResponseNull() throws Exception {
        when(converterMock.java2JsonResponse(anyObject())).thenThrow(JsonProcessingException.class);
        String result = handler.handleRequest(jsonRequest);
        assertTrue(result.contains("Error in CalculatedChartHandler"));
    }

    @Test
    public void handleRequestInvalidJson() throws Exception {
        when(validatedObjectMock.isValid()).thenReturn(false);
        String invalidJsonRequest = "{\"xxx\":\"yyy\"}";
        String result = handler.handleRequest(invalidJsonRequest);
        assertTrue(result.contains("Error in CalculatedChartHandler"));
    }
}
