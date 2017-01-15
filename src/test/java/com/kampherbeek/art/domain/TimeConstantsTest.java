package com.kampherbeek.art.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeConstantsTest {
    @Test
    public void getValue() throws Exception {
        assertEquals(3600, TimeConstants.SECONDS_PER_HOUR.getValue());
    }
}