package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.BodyPositionRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BodyPositionJsonConverter extends ConverterParent {

    public BodyPositionRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, BodyPositionRequest.class);
    }
}

