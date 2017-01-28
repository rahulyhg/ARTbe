package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.HousePositionsRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HousePositionsJsonConverter extends ConverterParent {

    public HousePositionsRequest jsonRequest2Java(@NonNull final String input) throws IOException {
        return mapper.readValue(input, HousePositionsRequest.class);
    }
}
