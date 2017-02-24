package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.SingleCyclesJsonConverter;
import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import com.kampherbeek.art.json.validators.SingleCyclesValidator;
import com.kampherbeek.art.solvers.SingleCyclesSolver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SingleCyclesHandlerTest {

    private final String jsonRequest = "{\"internalId\":3,\"startJdnr\":1234567.89,\"endJdnr\":1234867.89," +
            "\"calculationPreferences\":{\"flags\":[\"SWIEPH\",\"SPEED\"]},\"periodResultFormat\":\"JSON\"," +
            "\"singleCyclesMethod\":\"SPEED\",\"locale\":\"en\"}";
    private final String correctResponse = "{\"dummy4correct\":\"response\"}";

    private SingleCyclesValidator validatorMock = mock(SingleCyclesValidator.class);
    private SingleCyclesJsonConverter converterMock = mock(SingleCyclesJsonConverter.class);
    private SingleCyclesSolver solverMock = mock(SingleCyclesSolver.class);
    private ValidatedObject validatedObjectMock = mock(ValidatedObject.class);
    private SingleCyclesRequest requestMock = mock(SingleCyclesRequest.class);
    private SingleCyclesHandler handler;

    @Before
    public void setUp() throws Exception {
        when(validatorMock.handleJson(anyString(), anyObject())).thenReturn(validatedObjectMock);
        when(validatedObjectMock.isValid()).thenReturn(true);
        when(validatedObjectMock.getObject()).thenReturn(requestMock);
        when(validatorMock.handleJson(anyString(), anyObject())).thenReturn(validatedObjectMock);
        when(converterMock.java2JsonResponse(anyObject())).thenReturn(correctResponse);
        handler = new SingleCyclesHandler(validatorMock, converterMock, solverMock);

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
        assertTrue(result.contains("Error in SingleCyclesHandler"));
    }

    @Test
    public void handleRequestInvalidJson() throws Exception {
        when(validatedObjectMock.isValid()).thenReturn(false);
        String invalidJsonRequest = "{\"xxx\": \"yyy\"}";
        String result = handler.handleRequest(invalidJsonRequest);
        assertTrue(result.contains("Error in SingleCyclesHandler"));
    }

}

