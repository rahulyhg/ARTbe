package com.kampherbeek.art.calc;

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
    private JdnrCalculator calculator;

    @Before
    public void setUp() throws Exception {
        when(requestMock.getYear()).thenReturn(2017);
        when(requestMock.getMonth()).thenReturn(1);
        when(requestMock.getDay()).thenReturn(2);
        when(requestMock.getHours()).thenReturn(20);
        when(requestMock.getMinutes()).thenReturn(29);
        when(requestMock.getSeconds()).thenReturn(0);
        calculator = new JdnrCalculator();
    }

    @Test
    public void calcJd() throws Exception {
        double jdnr = calculator.calcJd(requestMock);
        assertEquals(2457768.5355613427, jdnr, DOUBLE_MARGIN.getValue());
    }
}