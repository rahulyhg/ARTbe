package com.kampherbeek.art.util;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class JsonReaderTest {

    private final String existingFilePath = "src/test/resources/testdata.json";
    private final String notExistingFilePath = "src/test/resources/xtestdatax.json";
    private final String noParseFilePath = "src/test/resources/testdata_noparse.json";


    private JsonReader reader;

    @Before
    public void setUp() throws Exception {

        reader = new JsonReader();
    }

    @Test
    public void readObjectFromFile() throws Exception {
        try {
            File testFile = new File(existingFilePath);
            JSONObject jsonObject = reader.readObjectFromFile(testFile);
            assertTrue("No exception occurred", true);
        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test (expected = RuntimeException.class)
    public void readObjectFromFileNoParse() throws Exception {
        File testFile = new File(noParseFilePath);
        JSONObject jsonObject = reader.readObjectFromFile(testFile);
    }

    @Test (expected = RuntimeException.class)
    public void readObjectFromFileNotExists() throws Exception {
        File testFile = new File(notExistingFilePath);
        JSONObject jsonObject = reader.readObjectFromFile(testFile);
    }

}