package com.kampherbeek.art.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class JsonReader {


    public JSONObject readObjectFromFile(File inputData) {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(inputData));
            return (JSONObject) object;
        } catch (ParseException pe) {
            throw new RuntimeException("Could not parse results of : " + inputData + " . Original message " + pe.getMessage());
        } catch (IOException ioe) {
            throw new RuntimeException("Could not read file : " + inputData + " . Original message " + ioe.getMessage());
        }
    }


}
