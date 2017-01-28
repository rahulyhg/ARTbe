package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.BodynamesRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BodynamesJsonConverter extends ConverterParent {

    @Override
    public BodynamesRequest jsonRequest2Java(@NonNull final String input) throws IOException {
        return mapper.readValue(input, BodynamesRequest.class);
    }
}


