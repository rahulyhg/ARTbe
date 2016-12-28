package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BodynamesResponseTest {

    private List<StandardSelectionItem> allSystems;
    private BodynamesResponse response;

    @Before
    public void setUp() throws Exception {
        allSystems = new ArrayList<>();
        response = new BodynamesResponse(allSystems);
    }

    @Test
    public void getBodynames() throws Exception {
        assertEquals(allSystems, response.getBodynames());
    }
}
