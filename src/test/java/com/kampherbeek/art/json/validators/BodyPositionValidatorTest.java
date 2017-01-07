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
    private final double jdnrCorrect = 2857140.5;
    private final double jdnr2High = 7857140.5;
    private final double jdnr2Low = -3026605.5;
    private final int flagValue = 1;
    private final int internalIdCorrect = 3;
    private final int internalIdFalse = 33333;
    private final int internalIdReserved = -1;

    private BodyPositionValidator validator;

    @Before
    public void setUp() throws Exception {
        when(requestMock.getJdnr()).thenReturn(jdnrCorrect);
        when(requestMock.getFlagValue()).thenReturn(flagValue);
        when(requestMock.getInternalId()).thenReturn(internalIdCorrect);
        validator = new BodyPositionValidator();
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.isValid(requestMock));
    }

    @Test
    public void isValidJdnr2High() throws Exception {
        when(requestMock.getJdnr()).thenReturn(jdnr2High);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidJdnr2Low() throws Exception {
        when(requestMock.getJdnr()).thenReturn(jdnr2Low);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidInternalIdWrong() throws Exception {
        when(requestMock.getInternalId()).thenReturn(internalIdFalse);
        assertFalse(validator.isValid(requestMock));
    }


    @Test
    public void isValidNullValue() throws Exception {
        when(requestMock.getInternalId()).thenReturn(internalIdReserved);
        assertFalse(validator.isValid(null));
    }

}
