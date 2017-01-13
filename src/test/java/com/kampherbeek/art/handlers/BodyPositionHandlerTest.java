package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.BodyPositionJsonConverter;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.validators.BodyPositionValidator;
import com.kampherbeek.art.solvers.BodyPositionSolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BodyPositionHandlerTest {

    @Mock
    private BodyPositionValidator validatorMock = mock(BodyPositionValidator.class);
    @Mock
    private BodyPositionJsonConverter converterMock = mock(BodyPositionJsonConverter.class);
    @Mock
    private BodyPositionSolver solverMock = mock(BodyPositionSolver.class);
    @Mock
    private ValidatedObject validatedObjectMock = mock(ValidatedObject.class);
    @Mock
    private BodyPositionRequest requestMock = mock(BodyPositionRequest.class);
    private final String jsonRequest = "{\"internalId\":3,\"jdnr\":1234567.89,\"flagValue\":1}";
    private final String invalidJsonRequest = "{\"xxx\": \"yyy\"}";
    private final String correctResponse = "{\"dummy4correct\":\"response\"}";
    private BodyPositionHandler handler;


    @Before
    public void setUp() throws Exception {
        when(requestMock.getJdnr()).thenReturn(1234567.89);
        when(validatorMock.handleJson(anyString(), anyObject())).thenReturn(validatedObjectMock);
        when(validatedObjectMock.isValid()).thenReturn(true);
        when(validatedObjectMock.getObject()).thenReturn(requestMock);
        when(validatorMock.handleJson(anyString(), anyObject())).thenReturn(validatedObjectMock);
        when(converterMock.java2JsonResponse(anyObject())).thenReturn(correctResponse);
        handler = new BodyPositionHandler(validatorMock, converterMock, solverMock);
    }

    @Test
    public void handleRequest() throws Exception {
        String result = handler.handleRequest(jsonRequest);
        assertEquals(correctResponse, result);
    }

    @Test
    public void handleRequestResponseNull() throws Exception {
        when(converterMock.java2JsonResponse(anyObject())).thenThrow(JsonProcessingException.class);
        String result = handler.handleRequest(jsonRequest);
        assertTrue(result.contains("Error in BodyPositionHandler"));
    }

    @Test
    public void handleRequestInvalidJson() throws Exception {
        when(validatedObjectMock.isValid()).thenReturn(false);
        String result = handler.handleRequest(invalidJsonRequest);
        assertTrue(result.contains("Error in BodyPositionHandler"));
    }
}

