package com.kampherbeek.art.json.validators.helpers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JdnrHelperTest {

    private final double jdnrCorrect = 2857140.5;
    private final double jdnr2High = 7857140.5;
    private final double jdnr2Low = -3026605.5;

    private JdnrHelper validatorHelper;

    @Before
    public void setUp() throws Exception {
        validatorHelper = new JdnrHelper();
    }

    @Test
    public void jdnrIsValid() throws Exception {
        assertTrue(validatorHelper.isValid(jdnrCorrect));
        assertFalse(validatorHelper.isValid(jdnr2High));
        assertFalse(validatorHelper.isValid(jdnr2Low));
    }


}