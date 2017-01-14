package com.kampherbeek.art.json;

import com.kampherbeek.art.json.representation.VersionRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidatedObjectTest {

    private Object object;
    private ValidatedObject validatedObject;

    @Before
    public void setUp() throws Exception {
        object = new VersionRequest();
        String versionType = "Short";
        ((VersionRequest) object).setVersionType(versionType);
        boolean isValid = true;
        validatedObject = new ValidatedObject(isValid, object);
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validatedObject.isValid());
    }

    @Test
    public void getObject() throws Exception {
        assertEquals(object, validatedObject.getObject());
        assertTrue(validatedObject.getObject() instanceof VersionRequest);
    }
}