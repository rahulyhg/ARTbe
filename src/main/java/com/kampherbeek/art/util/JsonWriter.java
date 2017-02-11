package com.kampherbeek.art.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Writes an object to file using Json format.
 * Based on an example at: http://www.studytrails.com/java/json/jackson-create-json.jsp
 */
@Component
public class JsonWriter {

    public void write2File(String pathFilename, Object object2Write, boolean useIndent) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, useIndent);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        try {
            File jsonFile = new File(pathFilename);
            mapper.writeValue(jsonFile, object2Write);
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file, using path and filename :" + pathFilename +
                    " . Original message: " + e.getMessage());
        }
    }
}
