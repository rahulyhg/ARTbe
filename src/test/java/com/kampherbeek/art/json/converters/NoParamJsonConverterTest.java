package com.kampherbeek.art.json.converters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class NoParamJsonConverterTest {

    private NoParamJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new NoParamJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        assertNull(converter.jsonRequest2Java("dummy"));
    }
}
