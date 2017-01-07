package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.EpsilonRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EpsilonValidatorTest {

    private final double jdnrCorrect = 2857140.5;
    private final double jdnr2High = 7857140.5;
    private final double jdnr2Low = -3026605.5;

    @Mock
    private EpsilonRequest requestMock = mock(EpsilonRequest.class);

    private EpsilonValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new EpsilonValidator();
    }

    @Test
    public void isValid() throws Exception {
        when(requestMock.getJdnr()).thenReturn(jdnrCorrect);
        assertTrue(validator.isValid(requestMock));
    }

    @Test
    public void isValidTooLow() throws Exception {
        when(requestMock.getJdnr()).thenReturn(jdnr2Low);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidTooHigh() throws Exception {
        when(requestMock.getJdnr()).thenReturn(jdnr2High);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidNullValue() throws Exception {
        assertFalse(validator.isValid(null));
    }

}