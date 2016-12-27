package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HouseSystemsResponseTest {

    private List<StandardSelectionItem> allSystems;
    private HouseSystemsResponse response;

    @Before
    public void setUp() throws Exception {
        allSystems = new ArrayList<>();
        response = new HouseSystemsResponse(allSystems);
    }

    @Test
    public void getHouseSystems() throws Exception {
        assertEquals(allSystems, response.getHouseSystems());
    }
}