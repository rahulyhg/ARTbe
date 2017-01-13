package com.kampherbeek.art.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class SimpleDateTimeTest {

    @Mock
    private SimpleDate dateMock = mock(SimpleDate.class);
    @Mock
    private SimpleTime timeMock = mock(SimpleTime.class);
    private SimpleDateTime simpleDateTime;

    @Before
    public void setUp() throws Exception {
        simpleDateTime = new SimpleDateTime(dateMock, timeMock);
    }

    @Test
    public void getSimpleDate() throws Exception {
        assertEquals(dateMock, simpleDateTime.getSimpleDate());
    }

    @Test
    public void getSimpleTime() throws Exception {
        assertEquals(timeMock, simpleDateTime.getSimpleTime());
    }
}