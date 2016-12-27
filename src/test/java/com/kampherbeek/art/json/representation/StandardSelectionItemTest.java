package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardSelectionItemTest {

    private final String id = "myId";
    private final String value = "myValue";
    private StandardSelectionItem item;

    @Before
    public void setUp() throws Exception {
        item = new StandardSelectionItem(id, value);
    }

    @Test
    public void getId() throws Exception {
        assertEquals(id, item.getId());
    }

    @Test
    public void getValue() throws Exception {
        assertEquals(value, item.getValue());
    }
}