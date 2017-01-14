package com.kampherbeek.art.json.validators;

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
    private List<Integer> internalIdsFalse;
    private BodySetPositionValidator validator;

    @Before
    public void setUp() throws Exception {
        List<Integer> internalIdsCorrect = createInternalIds();
        internalIdsFalse = createInternalIdsWithError();
        double jdnrCorrect = 2857140.5;
        when(requestMock.getJdnr()).thenReturn(jdnrCorrect);
        int flagValue = 1;
        when(requestMock.getFlagValue()).thenReturn(flagValue);
        when(requestMock.getInternalIds()).thenReturn(internalIdsCorrect);
        validator = new BodySetPositionValidator();
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.isValid(requestMock));
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

    @Test
    public void isValidJdnr2High() throws Exception {
        double jdnr2High = 7857140.5;
        when(requestMock.getJdnr()).thenReturn(jdnr2High);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidJdnr2Low() throws Exception {
        double jdnr2Low = -3026605.5;
        when(requestMock.getJdnr()).thenReturn(jdnr2Low);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidInternalIdsWrong() throws Exception {
        when(requestMock.getInternalIds()).thenReturn(internalIdsFalse);
        assertFalse(validator.isValid(requestMock));
    }

    @Test
    public void isValidRequestNull() throws Exception {
        assertFalse(validator.isValid(null));
    }
}
