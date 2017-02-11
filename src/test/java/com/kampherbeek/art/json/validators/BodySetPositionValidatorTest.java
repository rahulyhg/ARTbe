package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.CalculationPreferences;
import com.kampherbeek.art.json.representation.BodySetPositionRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BodySetPositionValidatorTest {

    @Mock
    private BodySetPositionRequest requestMock = mock(BodySetPositionRequest.class);
    @Mock
    private CalculationPreferences preferencesMock = mock(CalculationPreferences.class);
    private List<Integer> internalIdsFalse;
    private List<Integer> internalIdsWithNegative;
    private BodySetPositionValidator validator;

    @Before
    public void setUp() throws Exception {
        List<Integer> internalIdsCorrect = createInternalIds();
        internalIdsFalse = createInternalIdsWithError();
        double jdnrCorrect = 2857140.5;
        when(requestMock.getJdnr()).thenReturn(jdnrCorrect);
        when(requestMock.getCalculationPreferences()).thenReturn(preferencesMock);
        when(requestMock.getInternalIds()).thenReturn(internalIdsCorrect);
        validator = new BodySetPositionValidator();
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.validated(requestMock));
    }

    private List<Integer> createInternalIds() {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            ids.add(i);
        }
        return ids;
    }

    private List<Integer> createInternalIdsWithError() {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            ids.add(i);
        }
        ids.add(999888777);
        return ids;
    }

    private List<Integer> createInternalIdsWithNegative() {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            ids.add(i);
        }
        ids.add(-2);
        return ids;
    }


    @Test
    public void isValidJdnr2High() throws Exception {
        double jdnr2High = 7857140.5;
        when(requestMock.getJdnr()).thenReturn(jdnr2High);
        assertFalse(validator.validated(requestMock));
    }

    @Test
    public void isValidJdnr2Low() throws Exception {
        double jdnr2Low = -3026605.5;
        when(requestMock.getJdnr()).thenReturn(jdnr2Low);
        assertFalse(validator.validated(requestMock));
    }

    @Test
    public void isValidInternalIdsWrong() throws Exception {
        when(requestMock.getInternalIds()).thenReturn(internalIdsFalse);
        assertFalse(validator.validated(requestMock));
    }

    @Test
    public void isValidInternalIdswithNegative() throws Exception {
        when(requestMock.getInternalIds()).thenReturn(internalIdsWithNegative);
        assertFalse(validator.validated(requestMock));
    }

}
