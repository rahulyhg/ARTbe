package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.BodynamesJsonConverter;
import com.kampherbeek.art.json.representation.BodynamesRequest;
import com.kampherbeek.art.json.validators.LookupListValidator;
import com.kampherbeek.art.solvers.BodynamesSolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BodynamesHandlerTest {

    private final String jsonRequest = "{\"locale\":\"en\"}";
    private final String correctResponse = "{\"dummy4correct\":\"response\"}";
    @Mock
    private LookupListValidator validatorMock = mock(LookupListValidator.class);
    @Mock
    private BodynamesJsonConverter converterMock = mock(BodynamesJsonConverter.class);
    @Mock
    private BodynamesSolver solverMock = mock(BodynamesSolver.class);
    @Mock
    private BodynamesRequest requestMock = mock(BodynamesRequest.class);
    @Mock
    private ValidatedObject validatedObjectMock = mock(ValidatedObject.class);
    private BodynamesHandler handler;

    @Before
    public void setUp() throws Exception {
        when(requestMock.getLocale()).thenReturn("en");
        when(validatedObjectMock.isValid()).thenReturn(true);
        when(validatedObjectMock.getObject()).thenReturn(requestMock);
        when(validatorMock.handleJson(anyString(), anyObject())).thenReturn(validatedObjectMock);
        when(converterMock.java2JsonResponse(anyObject())).thenReturn(correctResponse);
        handler = new BodynamesHandler(validatorMock, converterMock, solverMock);
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
        assertTrue(result.contains("Error in BodynamesHandler"));
    }

    @Test
    public void handleRequestInvalidJson() throws Exception {
        when(validatedObjectMock.isValid()).thenReturn(false);
        String invalidJsonRequest = "{\"xxx\":\"yyy\"}";
        String result = handler.handleRequest(invalidJsonRequest);
        assertTrue(result.contains("Error in BodynamesHandler"));
    }
}
