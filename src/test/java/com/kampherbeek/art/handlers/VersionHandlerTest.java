package com.kampherbeek.art.handlers;

import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.VersionJsonConverter;
import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import com.kampherbeek.art.json.validators.VersionValidator;
import com.kampherbeek.art.solvers.VersionSolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VersionHandlerTest {

    private final String correctJsonRequest = "{\"versionType\":\"full\"}";
    private final String invalidJsonRequest = "abc";
    private final String correctResponse = "{\"versionType\":\"full\",\"versionId\":\"1.2.3\"}";
    private final String versionId = "1.2.3";
    private final String versionType = "short";
    @Mock
    private VersionValidator validatorMock = mock(VersionValidator.class);
    @Mock
    private VersionJsonConverter converterMock = mock(VersionJsonConverter.class);
    @Mock
    private ValidatedObject validatedObjectMock = mock(ValidatedObject.class);
    @Mock
    private VersionRequest requestMock = mock(VersionRequest.class);
    @Mock
    private VersionResponse responseMock = mock(VersionResponse.class);
    @Mock
    private VersionSolver solverMock = mock(VersionSolver.class);
    private VersionHandler handler;

    @Before
    public void setUp() throws Exception {
        when(requestMock.getVersionType()).thenReturn(versionType);
        when(validatedObjectMock.isValid()).thenReturn(true);
        when(validatedObjectMock.getObject()).thenReturn(requestMock);
        when(validatorMock.handleJson(anyString(),anyObject())).thenReturn(validatedObjectMock);
        when(converterMock.java2JsonResponse(anyObject())).thenReturn(correctResponse);
        handler = new VersionHandler(validatorMock, converterMock, solverMock);
    }

    @Test
    public void handleRequest() throws Exception {
        String result = handler.handleRequest(correctJsonRequest);
        assertEquals(correctResponse, result);
    }

}
