package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.domain.SimpleDateTime;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.JdnrJsonConverter;
import com.kampherbeek.art.json.representation.JdnrRequest;
import com.kampherbeek.art.json.validators.JdnrValidator;
import com.kampherbeek.art.solvers.JdnrSolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JdnrHandlerTest {

    @Mock
    private JdnrValidator validatorMock = mock(JdnrValidator.class);
    @Mock
    private JdnrJsonConverter converterMock = mock(JdnrJsonConverter.class);
    @Mock
    private JdnrSolver solverMock = mock(JdnrSolver.class);
    @Mock
    private JdnrRequest requestMock = mock(JdnrRequest.class);
    @Mock
    private ValidatedObject validatedObjectMock = mock(ValidatedObject.class);
    @Mock
    private SimpleDateTime dateTimeMock = mock(SimpleDateTime.class);

    private final String jsonRequest =
            "{\"simpleDateTime\":{\"simpleDate\":{\"year\":2016,\"month\":1,\"day\":2,\"gregorian\":true},\"simpleTime\":{\"hour\":20,\"minute\":41,\"second\":0}}}";
    private final String jsonResponse = "xxx";

    private JdnrHandler handler;




    @Before
    public void setUp() throws Exception {
        when(requestMock.getSimpleDateTime()).thenReturn(dateTimeMock);
        when(validatedObjectMock.isValid()).thenReturn(true);
        when(validatedObjectMock.getObject()).thenReturn(requestMock);
        when(validatorMock.handleJson(anyString(),anyObject())).thenReturn(validatedObjectMock);
        when(converterMock.java2JsonResponse(anyObject())).thenReturn(jsonResponse);
        handler = new JdnrHandler(validatorMock, converterMock, solverMock);
    }

    @Test
    public void handleRequest() throws Exception {
        String result = handler.handleRequest(jsonRequest);
        assertEquals(jsonResponse, result);
    }

    @Test
    public void handleRequestResponseNull() throws Exception {
        when(converterMock.java2JsonResponse(anyObject())).thenThrow(JsonProcessingException.class);
        String result = handler.handleRequest(jsonRequest);
        assertTrue(result.contains("Error in JdnrHandler"));
    }

    @Test
    public void handleRequestInvalid() throws Exception {
        when(validatedObjectMock.isValid()).thenReturn(false);
        String result = handler.handleRequest(jsonRequest);
        assertTrue(result.contains("Error in JdnrHandler"));
    }


}
