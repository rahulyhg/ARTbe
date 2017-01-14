package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.BodySetPositionRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BodySetPositionJsonConverter extends ConverterParent {

    public BodySetPositionRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, BodySetPositionRequest.class);
    }
}

