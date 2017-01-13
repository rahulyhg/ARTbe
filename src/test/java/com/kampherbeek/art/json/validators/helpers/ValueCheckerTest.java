package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.domain.IntegerLimits;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValueCheckerTest {

    private final int validInt = 10;
    private final int invalidValue= 13;
    private final double validDouble = -53.2;
    private final double invalidDouble = 99.9;
    private final IntegerLimits intLimits = IntegerLimits.MONTH;
    private final FloatingLimits floatingLimits = FloatingLimits.LATITUDE;
    private ValueChecker valueChecker;

    @Before
    public void setUp() throws Exception {
        valueChecker = new ValueChecker();
    }

    @Test
    public void checkValue4Int() throws Exception {
        assertTrue(valueChecker.checkValue(validInt, intLimits));
        assertFalse(valueChecker.checkValue(invalidValue, intLimits));
    }

    @Test
    public void checkValue4Double() throws Exception {
        assertTrue(valueChecker.checkValue(validDouble, floatingLimits));
        assertFalse(valueChecker.checkValue(invalidDouble, floatingLimits));
    }

}