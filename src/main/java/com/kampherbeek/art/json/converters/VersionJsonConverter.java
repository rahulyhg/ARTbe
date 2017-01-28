package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.VersionRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class VersionJsonConverter extends ConverterParent {

    public VersionRequest jsonRequest2Java(@NonNull final String input) throws IOException {
        return mapper.readValue(input, VersionRequest.class);
    }
}
