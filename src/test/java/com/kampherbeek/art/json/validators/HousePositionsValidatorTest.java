package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.HouseSystems;
import com.kampherbeek.art.domain.Location;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import com.kampherbeek.art.json.validators.helpers.JdnrHelper;
import com.kampherbeek.art.json.validators.helpers.LocationHelper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HousePositionsValidatorTest {

    @Mock
    private Location locationMock = mock(Location.class);
    @Mock
    private HousePositionsRequest requestMock = mock(HousePositionsRequest.class);
    @Mock
    private LocationHelper locationHelperMock = mock(LocationHelper.class);
    @Mock
    private JdnrHelper jdnrHelperMock = mock(JdnrHelper.class);
    private final double jdnr = 1234567.89;

    private HousePositionsValidator validator;

    @Before
    public void setUp() throws Exception {
        when(requestMock.getLocation()).thenReturn(locationMock);
        when(requestMock.getSystem()).thenReturn(HouseSystems.ALCABITIUS.getInternalId());
        when(requestMock.getJdnr()).thenReturn(jdnr);
        when(locationHelperMock.isValid(anyObject())).thenReturn(true);
        when(jdnrHelperMock.isValid(anyDouble())).thenReturn(true);
        validator = new HousePositionsValidator(locationHelperMock, jdnrHelperMock);
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.isValid(requestMock));
    }

}