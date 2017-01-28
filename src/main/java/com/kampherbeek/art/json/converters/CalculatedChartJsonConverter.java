package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.CalculatedChartRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CalculatedChartJsonConverter extends ConverterParent {
@Override
    public CalculatedChartRequest jsonRequest2Java(@NonNull final String input) throws IOException {
        return mapper.readValue(input, CalculatedChartRequest.class);
    }
}
