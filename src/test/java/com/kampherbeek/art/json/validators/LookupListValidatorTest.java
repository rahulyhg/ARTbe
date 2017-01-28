package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.BodynamesRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LookupListValidatorTest {

    @Mock
    private BodynamesRequest requestMock = mock(BodynamesRequest.class);
    private LookupListValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new LookupListValidator();
    }

    @Test
    public void isValid() throws Exception {
        String correctLocale = "nl";
        when(requestMock.getLocale()).thenReturn(correctLocale);
        assertTrue(validator.validated(requestMock));
    }

    @Test
    public void isValidWrongValue() throws Exception {
        String wrongLocale = "wrong";
        when(requestMock.getLocale()).thenReturn(wrongLocale);
        assertFalse(validator.validated(requestMock));
    }
}
