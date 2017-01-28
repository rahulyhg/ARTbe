package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.BodyPositionRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BodyPositionJsonConverter extends ConverterParent {
@Override
    public BodyPositionRequest jsonRequest2Java(@NonNull final String input) throws IOException {
        return mapper.readValue(input, BodyPositionRequest.class);
    }
}

