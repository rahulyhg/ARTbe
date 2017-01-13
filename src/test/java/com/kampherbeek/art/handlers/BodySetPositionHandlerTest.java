package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.BodySetPositionJsonConverter;
import com.kampherbeek.art.json.representation.BodySetPositionRequest;
import com.kampherbeek.art.json.validators.BodySetPositionValidator;
import com.kampherbeek.art.solvers.BodySetPositionSolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BodySetPositionHandlerTest {

    @Mock
    private BodySetPositionValidator validatorMock = mock(BodySetPositionValidator.class);
    @Mock
    private BodySetPositionJsonConverter converterMock = mock(BodySetPositionJsonConverter.class);
    @Mock
    private BodySetPositionSolver solverMock = mock(BodySetPositionSolver.class);
    @Mock
    private ValidatedObject validatedObjectMock = mock(ValidatedObject.class);
    @Mock
    private BodySetPositionRequest requestMock = mock(BodySetPositionRequest.class);
    private final String jsonRequest = "{\"jdnr\":1234567.89,\"flagValue\":1,\"internalIds\":[0,1,2,3]}";
    private final String invalidJsonRequest = "{\"xxx\": \"yyy\"}";
    private final String correctResponse = "{\"dummy4correct\":\"response\"}";
    private BodySetPositionHandler handler;

    @Before
    public void setUp() throws Exception {
        when(requestMock.getJdnr()).thenReturn(1234567.89);
        when(validatorMock.handleJson(anyString(), anyObject())).thenReturn(validatedObjectMock);
        when(validatedObjectMock.isValid()).thenReturn(true);
        when(validatedObjectMock.getObject()).thenReturn(requestMock);
        when(validatorMock.handleJson(anyString(), anyObject())).thenReturn(validatedObjectMock);
        when(converterMock.java2JsonResponse(anyObject())).thenReturn(correctResponse);
        handler = new BodySetPositionHandler(validatorMock, converterMock, solverMock);
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
        assertTrue(result.contains("Error in BodySetPositionHandler"));
    }

    @Test
    public void handleRequestInvalidJson() throws Exception {
        when(validatedObjectMock.isValid()).thenReturn(false);
        String result = handler.handleRequest(invalidJsonRequest);
        assertTrue(result.contains("Error in BodySetPositionHandler"));
    }
}

