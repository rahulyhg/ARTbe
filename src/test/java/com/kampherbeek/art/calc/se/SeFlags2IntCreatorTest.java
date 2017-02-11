package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.CalculationFlags;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SeFlags2IntCreatorTest {

    private SeFlags2IntCreator seFlags2IntCreator;

    @Before
    public void setUp() throws Exception {
        seFlags2IntCreator = new SeFlags2IntCreator();
    }

    @Test
    public void createFlags() throws Exception {
        List<CalculationFlags> listWithFlags = constructList();
        int expectedValue = 2320;
        int result = seFlags2IntCreator.createFlags(listWithFlags);
        assertEquals(expectedValue, result);
    }

    private List<CalculationFlags> constructList() {
        List<CalculationFlags> myList = new ArrayList<>();
        myList.add(CalculationFlags.SPEED);
        myList.add(CalculationFlags.EQUATORIAL);
        myList.add(CalculationFlags.TRUEPOS);
        return myList;
    }
}
