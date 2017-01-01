package com.kampherbeek.art.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CalendarsTest {

    @Test
    public void isGregorianCal() throws Exception {
        assertTrue(Calendars.GREGORIAN.isGregorianCal());
    }
}