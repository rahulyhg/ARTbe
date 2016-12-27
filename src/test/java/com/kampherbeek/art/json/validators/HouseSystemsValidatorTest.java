package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HouseSystemsValidatorTest {

    private final String correctLocale = "nl";
    private final String wrongLocale = "wrong";
    private final String invalidJsonType = "{\"dummyType\":\"wrong\"}";
    @Mock
    private HouseSystemsRequest requestMock = mock(HouseSystemsRequest.class);
    private HouseSystemsValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new HouseSystemsValidator();
    }

    @Test
    public void isValid() throws Exception {
        when(requestMock.getLocale()).thenReturn(correctLocale);
        assertTrue(validator.isValid(requestMock));
    }

    @Test
    public void isValidWrongValue() throws Exception {
        when(requestMock.getLocale()).thenReturn(wrongLocale);
        assertFalse(validator.isValid(requestMock));
    }



}

