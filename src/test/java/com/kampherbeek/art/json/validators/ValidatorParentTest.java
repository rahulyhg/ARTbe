package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.VersionJsonConverter;
import com.kampherbeek.art.json.representation.VersionRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidatorParentTest {

    private final String jsonInputCorrect = "{\"versionType\":\"full\"}";
    @Mock
    private VersionRequest requestMock = mock(VersionRequest.class);
    @Mock
    private VersionJsonConverter converterMock = mock(VersionJsonConverter.class);
    @Mock
    private IOException ioExceptionMock = mock(IOException.class);
    private ValidatorParent validator;

    @Before
    public void setUp() throws Exception {
        when(converterMock.jsonRequest2Java(anyString())).thenReturn(requestMock);
        validator = new VersionValidator();
    }

    @Test
    public void handleJson() throws Exception {
        String correctVersionType = "full";
        when(requestMock.getVersionType()).thenReturn(correctVersionType);
        ValidatedObject result = validator.handleJson(jsonInputCorrect, converterMock);
        assertTrue(result.isValid());
        assertEquals(requestMock, result.getObject());
    }

    @Test
    public void handleJsonWrongValue() throws Exception {
        String versionTypeError = "error";
        when(requestMock.getVersionType()).thenReturn(versionTypeError);
        ValidatedObject result = validator.handleJson(jsonInputCorrect, converterMock);
        assertFalse(result.isValid());
        assertEquals("Wrong value.", result.getObject());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void handleJsonInvalid() throws Exception {

        when(ioExceptionMock.getMessage()).thenReturn("Error");
        when(converterMock.jsonRequest2Java(anyString())).thenThrow(ioExceptionMock);
        String jsonInputError = "{\"dummy\":\"xxx\"}";
        ValidatedObject validatedObject = validator.handleJson(jsonInputError, converterMock);
        assertFalse(validatedObject.isValid());
    }
}

