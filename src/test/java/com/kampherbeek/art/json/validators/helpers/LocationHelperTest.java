package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.Location;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationHelperTest {


    @Mock
    private final Location locationMock = mock(Location.class);
    @Mock
    private final ValueChecker checkerMock = mock(ValueChecker.class);

    private LocationHelper validatorHelper;

    @Before
    public void setUp() throws Exception {
        when(checkerMock.checkValue(anyDouble(),anyObject())).thenReturn(true);
        validatorHelper = new LocationHelper(checkerMock);
    }

    @Test
    public void locationIsValid() throws Exception {
        assertTrue(validatorHelper.isValid(locationMock));
    }

    @Test
    public void locationIsValidLongTooHigh() throws Exception {
        when(checkerMock.checkValue(anyDouble(),anyObject())).thenReturn(false);
        assertFalse(validatorHelper.isValid(locationMock));
    }


}