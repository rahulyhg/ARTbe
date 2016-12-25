package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.VersionJsonConverter;
import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import com.kampherbeek.art.json.validators.VersionValidator;
import com.kampherbeek.art.util.PropertiesReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VersionHandlerTest {

    private final String correctJsonType = "{\"versionType\":\"full\"}";
    private final String invalidJsonType = "abc";
    private final String wrongJsonType = "{\"versionType\":\"banana\"}";
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
    private VersionResponse responseMock = mock(VersionResponse.class);
    @Mock
    private VersionRequest requestMock = mock(VersionRequest.class);
    @Mock
    private PropertiesReader readerMock = mock(PropertiesReader.class);
    private VersionHandler handler;

    @Before
    public void setUp() throws Exception {
        when(readerMock.getValueForProperty(anyString())).thenReturn(versionId);
        when(responseMock.getVersionType()).thenReturn(versionType);
        when(responseMock.getVersionId()).thenReturn(versionId);
        when(requestMock.getVersionType()).thenReturn(versionType);
        when(validatedObjectMock.isValid()).thenReturn(true);
        when(validatedObjectMock.getObject()).thenReturn(requestMock);
        when(validatorMock.handleJson(anyString())).thenReturn(validatedObjectMock);
        when(converterMock.java2JsonResponse(anyObject())).thenReturn(correctResponse);
        handler = new VersionHandler(validatorMock, converterMock, readerMock);
    }

    @Test
    public void handleRequest() throws Exception {
        String result = handler.handleRequest(correctJsonType);
        assertEquals(correctResponse, result);
    }

    @Test
    public void handleRequestWrongType() throws Exception {
        when(validatedObjectMock.isValid()).thenReturn(false);
        when(validatedObjectMock.getObject()).thenReturn("Wrong value");
        String result = handler.handleRequest(wrongJsonType);
        assertTrue(result.indexOf("Error") > -1);
    }


    @Test
    public void handleRequestInvalidJson() throws Exception {
        when(validatedObjectMock.isValid()).thenReturn(false);
        when(validatedObjectMock.getObject()).thenReturn("Wrong value");
        when(converterMock.jsonRequest2Java(anyString())).thenThrow(JsonProcessingException.class);
        String result = handler.handleRequest(invalidJsonType);
        assertTrue(result.indexOf("Error") > -1);
    }


}
