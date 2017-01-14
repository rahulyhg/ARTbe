package com.kampherbeek.art.calc;

import com.kampherbeek.art.domain.SimpleDate;
import com.kampherbeek.art.domain.SimpleDateTime;
import com.kampherbeek.art.domain.SimpleTime;
import com.kampherbeek.art.json.representation.JdnrRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JdnrCalculatorTest {

    @Mock
    private JdnrRequest requestMock = mock(JdnrRequest.class);
    @Mock
    private SimpleDateTime dateTimeMock = mock(SimpleDateTime.class);
    @Mock
    private SimpleDate dateMock = mock(SimpleDate.class);
    @Mock
    private SimpleTime timeMock = mock(SimpleTime.class);
    private JdnrCalculator calculator;

    @Before
    public void setUp() throws Exception {
        when(dateMock.getYear()).thenReturn(2017);
        when(dateMock.getMonth()).thenReturn(1);
        when(dateMock.getDay()).thenReturn(2);
        when(timeMock.getHour()).thenReturn(20);
        when(timeMock.getMinute()).thenReturn(29);
        when(timeMock.getSecond()).thenReturn(0);
        when(dateTimeMock.getSimpleDate()).thenReturn(dateMock);
        when(dateTimeMock.getSimpleTime()).thenReturn(timeMock);
        when(requestMock.getSimpleDateTime()).thenReturn(dateTimeMock);
        calculator = new JdnrCalculator();
    }

    @Test
    public void calcJd() throws Exception {
        double jdnr = calculator.calcJd(requestMock);
        assertEquals(2457769.353472222, jdnr, DOUBLE_MARGIN.getValue());
    }
}