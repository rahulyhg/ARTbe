package com.kampherbeek.art.json.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kampherbeek.art.json.representation.VersionRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class VersionJsonConverter extends ConverterParent {

    ObjectMapper mapper = new ObjectMapper();

    public VersionRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, VersionRequest.class);
    }

}
