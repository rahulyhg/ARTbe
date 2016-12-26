package com.kampherbeek.art.json.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HouseSystemsJsonConverter extends ConverterParent{

    ObjectMapper mapper = new ObjectMapper();

    public HouseSystemsRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, HouseSystemsRequest.class);
    }

}
