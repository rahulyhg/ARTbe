package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.JdnrRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JdnrJsonConverter extends ConverterParent {
@Override
    public JdnrRequest jsonRequest2Java(@NonNull final String input) throws IOException {
        return mapper.readValue(input, JdnrRequest.class);
    }
}
