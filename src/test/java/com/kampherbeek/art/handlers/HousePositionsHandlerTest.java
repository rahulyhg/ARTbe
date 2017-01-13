package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.HousePositionsJsonConverter;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import com.kampherbeek.art.json.validators.HousePositionsValidator;
import com.kampherbeek.art.solvers.HousePositionsSolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HousePositionsHandlerTest {

    @Mock
    private HousePositionsValidator validatorMock = mock(HousePositionsValidator.class);
    @Mock
    private HousePositionsJsonConverter converterMock = mock(HousePositionsJsonConverter.class);
    @Mock
    private HousePositionsSolver solverMock= mock(HousePositionsSolver.class);
    @Mock
    private ValidatedObject validatedObjectMock = mock(ValidatedObject.class);
    @Mock
    private HousePositionsRequest requestMock = mock(HousePositionsRequest.class);

    private final String jsonRequest = "{\"system\":4,\"jdnr\":2457139.8,\"location\":{\"longitude\":6.9,\"latitude\":52.23}}";
    private final String invalidJsonRequest = "{\"xxx\": \"yyy\"}";
    private final String correctResponse = "{\"dummy4correct\":\"response\"}";

    private HousePositionsHandler handler;


    @Before
    public void setUp() throws Exception {
        when(requestMock.getJdnr()).thenReturn(1234567.89);
        when(validatorMock.handleJson(anyString(), anyObject())).thenReturn(validatedObjectMock);
        when(validatedObjectMock.isValid()).thenReturn(true);
        when(validatedObjectMock.getObject()).thenReturn(requestMock);
        when(validatorMock.handleJson(anyString(), anyObject())).thenReturn(validatedObjectMock);
        when(converterMock.java2JsonResponse(anyObject())).thenReturn(correctResponse);
        handler = new HousePositionsHandler(validatorMock, converterMock, solverMock);
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
        assertTrue(result.contains("Error in HousePositionsHandler"));
    }

    @Test
    public void handleRequestInvalidJson() throws Exception {
        when(validatedObjectMock.isValid()).thenReturn(false);
        String result = handler.handleRequest(invalidJsonRequest);
        assertTrue(result.contains("Error in HousePositionsHandler"));
    }
}
