package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.IntegerLimits;
import com.kampherbeek.art.domain.SimpleTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleTimeHelperTest {

    @Mock
    private ValueChecker checkerMock = mock(ValueChecker.class);
    @Mock
    private SimpleTime timeMock = mock(SimpleTime.class);

    private SimpleTimeHelper helper;

    @Before
    public void setUp() throws Exception {
        when(checkerMock.checkValue(anyInt(), (IntegerLimits) anyObject())).thenReturn(true);
        helper = new SimpleTimeHelper(checkerMock);
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(helper.isValid(timeMock));
    }

    @Test
    public void isValidWrongValue() throws Exception {
        when(checkerMock.checkValue(anyInt(), (IntegerLimits) anyObject())).thenReturn(false);
        assertFalse(helper.isValid(timeMock));
    }
}