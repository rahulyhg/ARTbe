package com.kampherbeek.art.util;

import com.kampherbeek.art.config.Settings;
import com.kampherbeek.art.domain.EphemerisRanges;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class JsonWriterTest {

    private JsonWriter writer;
    @Before
    public void setUp() throws Exception {
        writer = new JsonWriter();
    }

    @Test
    public void write2File() throws Exception {
        try {
            writer.write2File("config/settings.json", constructObject(), true);
            assertTrue("No exception occurred", true);
        } catch (Exception e) {
            fail("An unexpectexd exception occurred: " + e.getMessage());
        }
    }

    @Test(expected = RuntimeException.class)
    public void write2FileIllegalFilename() throws Exception {
        writer.write2File("config/aa/a", constructObject(), true);
    }

    private Object constructObject() {
        Settings settings = new Settings();
        settings.setEphemerisRange(EphemerisRanges.CURRENT);
        settings.setSePath("se/");
        return settings;
    }

}