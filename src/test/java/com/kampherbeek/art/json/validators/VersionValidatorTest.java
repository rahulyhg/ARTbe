package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.converters.VersionJsonConverter;
import com.kampherbeek.art.json.representation.VersionRequest;
import org.junit.Before;
import org.mockito.Mock;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VersionValidatorTest {


    private final String correctJsonType = "{\"versionType\":\"full\"}";
    private final String correctType = "full";
    private final String wrongJsonType = "{\"versionType\":\"wrong\"}";
    private final String wrongType = "wrong";
    private final String invalidJsonType = "{\"dummyType\":\"wrong\", \"anotherType\":3}";
    @Mock
    private VersionJsonConverter converterMock = mock(VersionJsonConverter.class);
    @Mock
    private VersionRequest requestMock = mock(VersionRequest.class);
    private VersionValidator validator;

    @Before
    public void setUp() throws Exception {
        when(requestMock.getVersionType()).thenReturn(correctType);
        when(converterMock.jsonRequest2Java(anyString())).thenReturn(requestMock);
        validator = new VersionValidator();
    }

//    @Test
//    public void handleJson() throws Exception {
//        ValidatedObject result = validator.handleJson();
//        assertTrue(result.isValid());
//    }
//
//    @Test
//    public void handleJsonWrongType() throws Exception {
//        when(requestMock.getVersionType()).thenReturn(wrongType);
//        ValidatedObject result = validator.handleJson(wrongJsonType);
//        assertFalse(result.isValid());
//        assertTrue(result.getObject() instanceof String);
//    }
//
//    @Test
//    public void handleJsonInvalidType() throws Exception {
//        when(converterMock.jsonRequest2Java(anyString())).thenThrow(IOException.class);
//        ValidatedObject result = validator.handleJson(invalidJsonType);
//        assertFalse(result.isValid());
//    }

}