package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.BodyPositionRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BodyPositionValidatorTest {

    @Mock
    private BodyPositionRequest requestMock = mock(BodyPositionRequest.class);
    private BodyPositionValidator validator;

    @Before
    public void setUp() throws Exception {
        double jdnrCorrect = 2857140.5;
        when(requestMock.getJdnr()).thenReturn(jdnrCorrect);
        int flagValue = 1;
        when(requestMock.getFlagValue()).thenReturn(flagValue);
        int internalIdCorrect = 3;
        when(requestMock.getInternalId()).thenReturn(internalIdCorrect);
        validator = new BodyPositionValidator();
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.isValid(requestMock));
    }

    @Test
    public void isValidJdnr2High() throws Exception {
        double jdnr2High = 7857140.5;
        when(requestMock.getJdnr()).thenReturn(jdnr2High);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidJdnr2Low() throws Exception {
        double jdnr2Low = -3026605.5;
        when(requestMock.getJdnr()).thenReturn(jdnr2Low);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidInternalIdWrong() throws Exception {
        int internalIdFalse = 33333;
        when(requestMock.getInternalId()).thenReturn(internalIdFalse);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidNullValue() throws Exception {
        int internalIdReserved = -1;
        when(requestMock.getInternalId()).thenReturn(internalIdReserved);
        assertFalse(validator.isValid(null));
    }

    @Test
    public void isValidValueNegative() throws Exception {
        int internalIdNegative = -2;
        when(requestMock.getInternalId()).thenReturn(internalIdNegative);
        assertFalse(validator.isValid(null));
    }

}
