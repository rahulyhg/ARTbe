package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.BodySetPositionRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BodySetPositionJsonConverter extends ConverterParent {
@Override
    public BodySetPositionRequest jsonRequest2Java(@NonNull final String input) throws IOException {
        return mapper.readValue(input, BodySetPositionRequest.class);
    }
}

