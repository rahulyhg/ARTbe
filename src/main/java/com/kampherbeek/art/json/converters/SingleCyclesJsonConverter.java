package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SingleCyclesJsonConverter extends ConverterParent{

    @Override
    public SingleCyclesRequest jsonRequest2Java(@NonNull final String input) throws IOException {
        return mapper.readValue(input, SingleCyclesRequest.class);
    }
}

