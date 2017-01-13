package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.SimpleDate;
import com.kampherbeek.art.domain.SimpleDateTime;
import com.kampherbeek.art.domain.SimpleTime;
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
    @Mock
    private SimpleDateTime simpleDateTimeMock = mock(SimpleDateTime.class);
    @Mock
    private SimpleDate simpleDateMock = mock(SimpleDate.class);
    @Mock
    private SimpleTime simpleTimeMock = mock(SimpleTime.class);


    private final int year = 2016;
    private final int month = 1;
    private final int invalidMonth = 13;
    private final int day = 2;
    private final int hour = 20;
    private final int minute = 41;
    private final int second = 0;
    private final boolean isGregorian = true;


    private JdnrValidator validator;

    @Before
    public void setUp() throws Exception {

        when(simpleDateMock.getYear()).thenReturn(year);
        when(simpleDateMock.getMonth()).thenReturn(month);
        when(simpleDateMock.getDay()).thenReturn(day);
        when(simpleDateMock.isGregorian()).thenReturn(isGregorian);
        when(simpleTimeMock.getHour()).thenReturn(hour);
        when(simpleTimeMock.getMinute()).thenReturn(minute);
        when(simpleTimeMock.getSecond()).thenReturn(second);
        when(simpleDateTimeMock.getSimpleDate()).thenReturn(simpleDateMock);
        when(simpleDateTimeMock.getSimpleTime()).thenReturn(simpleTimeMock);
        when(requestMock.getSimpleDateTime()).thenReturn(simpleDateTimeMock);
        validator = new JdnrValidator();
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.isValid(requestMock));
    }

    @Test
    public void isValidFalse() throws Exception {
        when(simpleDateMock.getMonth()).thenReturn(invalidMonth);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidException() throws Exception {
        assertFalse(validator.isValid(null));
    }

}