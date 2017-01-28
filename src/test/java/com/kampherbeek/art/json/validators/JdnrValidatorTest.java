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
    private JdnrValidator validator;

    @Before
    public void setUp() throws Exception {

        int year = 2016;
        when(simpleDateMock.getYear()).thenReturn(year);
        int month = 1;
        when(simpleDateMock.getMonth()).thenReturn(month);
        int day = 2;
        when(simpleDateMock.getDay()).thenReturn(day);
        boolean isGregorian = true;
        when(simpleDateMock.isGregorian()).thenReturn(isGregorian);
        int hour = 20;
        when(simpleTimeMock.getHour()).thenReturn(hour);
        int minute = 41;
        when(simpleTimeMock.getMinute()).thenReturn(minute);
        int second = 0;
        when(simpleTimeMock.getSecond()).thenReturn(second);
        when(simpleDateTimeMock.getSimpleDate()).thenReturn(simpleDateMock);
        when(simpleDateTimeMock.getSimpleTime()).thenReturn(simpleTimeMock);
        when(requestMock.getSimpleDateTime()).thenReturn(simpleDateTimeMock);
        validator = new JdnrValidator();
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.validated(requestMock));
    }

    @Test
    public void isValidFalse() throws Exception {
        int invalidMonth = 13;
        when(simpleDateMock.getMonth()).thenReturn(invalidMonth);
        assertFalse(validator.validated(requestMock));
    }


}