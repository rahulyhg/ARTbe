package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HouseSystemsJsonConverter extends ConverterParent {

    @Override
    public HouseSystemsRequest jsonRequest2Java(@NonNull final String input) throws IOException {
        return mapper.readValue(input, HouseSystemsRequest.class);
    }
}
