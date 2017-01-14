package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.IntegerLimits;
import com.kampherbeek.art.domain.SimpleDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleDateHelperTest {

    @Mock
    private SimpleDate dateMock = mock(SimpleDate.class);
    @Mock
    private ValueChecker checkerMock = mock(ValueChecker.class);

    private SimpleDateHelper validatorHelper;

    @Before
    public void setUp() throws Exception {
        when(checkerMock.checkValue(anyInt(), (IntegerLimits) anyObject())).thenReturn(true);
        validatorHelper = new SimpleDateHelper(checkerMock);
    }

    @Test
    public void isSimpleDateValid() throws Exception {
        assertTrue(validatorHelper.isValid(dateMock));
    }

    @Test
    public void isSimpleDateValidWrongMonth() throws Exception {
        when(checkerMock.checkValue(anyInt(), (IntegerLimits) anyObject())).thenReturn(false);
        assertFalse(validatorHelper.isValid(dateMock));
    }
}