package com.kampherbeek.art.exceptions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnknownItemExceptionTest {
    @Test
    public void getMessage() throws Exception {
        final String item = "myItem";
        final String itemType = "myItemType";
        UnknownItemException uie = new UnknownItemException(itemType, item);
        String expected = "Could not find myItemType, searched for: myItem";
        assertEquals(expected, uie.getMessage());
    }
}
