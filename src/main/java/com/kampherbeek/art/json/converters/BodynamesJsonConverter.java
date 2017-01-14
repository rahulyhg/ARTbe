package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.BodynamesRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BodynamesJsonConverter extends ConverterParent {

    public BodynamesRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, BodynamesRequest.class);
    }
}


