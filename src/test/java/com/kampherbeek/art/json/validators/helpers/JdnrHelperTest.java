package com.kampherbeek.art.json.validators.helpers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JdnrHelperTest {

    private JdnrHelper validatorHelper;

    @Before
    public void setUp() throws Exception {
        validatorHelper = new JdnrHelper();
    }

    @Test
    public void jdnrIsValid() throws Exception {
        double jdnrCorrect = 2857140.5;
        assertTrue(validatorHelper.isValid(jdnrCorrect));
        double jdnr2High = 7857140.5;
        assertFalse(validatorHelper.isValid(jdnr2High));
        double jdnr2Low = -3026605.5;
        assertFalse(validatorHelper.isValid(jdnr2Low));
    }
}