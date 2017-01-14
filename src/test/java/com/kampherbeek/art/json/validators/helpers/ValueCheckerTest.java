package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.domain.IntegerLimits;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValueCheckerTest {

    private final IntegerLimits intLimits = IntegerLimits.MONTH;
    private final FloatingLimits floatingLimits = FloatingLimits.LATITUDE;
    private ValueChecker valueChecker;

    @Before
    public void setUp() throws Exception {
        valueChecker = new ValueChecker();
    }

    @Test
    public void checkValue4Int() throws Exception {
        int validInt = 10;
        assertTrue(valueChecker.checkValue(validInt, intLimits));
        int invalidValue = 13;
        assertFalse(valueChecker.checkValue(invalidValue, intLimits));
    }

    @Test
    public void checkValue4Double() throws Exception {
        double validDouble = -53.2;
        assertTrue(valueChecker.checkValue(validDouble, floatingLimits));
        double invalidDouble = 99.9;
        assertFalse(valueChecker.checkValue(invalidDouble, floatingLimits));
    }
}