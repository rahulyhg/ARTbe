package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.JdnrRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JdnrValidatorTest {

    @Mock
    private JdnrRequest requestMock = mock(JdnrRequest.class);

    private final int year = 2016;
    private final int month = 1;
    private final int invalidMonth = 13;
    private final int day = 2;
    private final int hours = 20;
    private final int minutes = 41;
    private final int seconds = 0;
    private final boolean isGregorian = true;


    private JdnrValidator validator;

    @Before
    public void setUp() throws Exception {
        when(requestMock.getYear()).thenReturn(year);
        when(requestMock.getMonth()).thenReturn(month);
        when(requestMock.getDay()).thenReturn(day);
        when(requestMock.getHours()).thenReturn(hours);
        when(requestMock.getMinutes()).thenReturn(minutes);
        when(requestMock.getSeconds()).thenReturn(seconds);
        when(requestMock.isGregorian()).thenReturn(isGregorian);
        validator = new JdnrValidator();
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.isValid(requestMock));
    }

    @Test
    public void isValidFalse() throws Exception {
        when(requestMock.getMonth()).thenReturn(invalidMonth);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidException() throws Exception {
        assertFalse(validator.isValid(null));
    }

}