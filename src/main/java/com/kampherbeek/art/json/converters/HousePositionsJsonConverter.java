package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.HousePositionsRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HousePositionsJsonConverter extends ConverterParent{

    public HousePositionsRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, HousePositionsRequest.class);
    }
}
