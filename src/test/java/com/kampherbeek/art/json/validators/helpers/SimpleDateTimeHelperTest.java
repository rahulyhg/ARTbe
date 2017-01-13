package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.SimpleDateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleDateTimeHelperTest {

    @Mock
    private SimpleDateHelper dateHelperMock = mock(SimpleDateHelper.class);
    @Mock
    private SimpleTimeHelper timeHelperMock = mock(SimpleTimeHelper.class);
    @Mock
    private SimpleDateTime dateTimeMock = mock(SimpleDateTime.class);

    private SimpleDateTimeHelper dateTimeHelper;

    @Before
    public void setUp() throws Exception {
        when(dateHelperMock.isValid(anyObject())).thenReturn(true);
        when(timeHelperMock.isValid(anyObject())).thenReturn(true);
        dateTimeHelper = new SimpleDateTimeHelper(dateHelperMock, timeHelperMock);
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(dateTimeHelper.isValid(dateTimeMock));
    }

    @Test
    public void isValidWrongValue() throws Exception {
        when(dateHelperMock.isValid(anyObject())).thenReturn(false);
        assertFalse(dateTimeHelper.isValid(dateTimeMock));
    }
}