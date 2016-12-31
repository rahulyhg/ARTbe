package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.HouseSystems;
import com.kampherbeek.art.domain.Location;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HousePositionsValidatorTest {

    private final double latitudeCorrect = 52.0;
    private final double latitude2High = 99.0;
    private final double latitude2Low = -99.0;
    private final double longitudeCorrect = 6.9;
    private final double longitude2High = 187.3;
    private final double longitude2Low = -187.3;
    private final double jdnrCorrect = 2857140.5;
    private final double jdnr2High = 7857140.5;
    private final double jdnr2Low = -3026605.5;

    @Mock
    private Location locationMock = mock(Location.class);
    @Mock
    private HousePositionsRequest requestMock = mock(HousePositionsRequest.class);

    private HousePositionsValidator validator;

    @Before
    public void setUp() throws Exception {
        when(locationMock.getLatitude()).thenReturn(latitudeCorrect);
        when(locationMock.getLongitude()).thenReturn(longitudeCorrect);
        when(requestMock.getLocation()).thenReturn(locationMock);
        when(requestMock.getJdnr()).thenReturn(jdnrCorrect);
        when(requestMock.getSystem()).thenReturn(HouseSystems.ALCABITIUS);
        validator = new HousePositionsValidator();
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.isValid(requestMock));
    }

    @Test
    public void isValidLong2High() throws Exception {
        when(locationMock.getLongitude()).thenReturn(longitude2High);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidLong2Low() throws Exception {
        when(locationMock.getLongitude()).thenReturn(longitude2Low);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidLat2High() throws Exception {
        when(locationMock.getLatitude()).thenReturn(latitude2High);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidLat2Low() throws Exception {
        when(locationMock.getLatitude()).thenReturn(latitude2Low);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidJdnr2High() throws Exception {
        when(requestMock.getJdnr()).thenReturn(jdnr2High);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidJdnr2Low() throws Exception {
        when(requestMock.getJdnr()).thenReturn(jdnr2Low);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidSystemNull() throws Exception {
        when(requestMock.getSystem()).thenReturn(null);
        assertFalse(validator.isValid(requestMock));
    }

}