package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.CalculatedChartRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CalculatedChartJsonConverter extends ConverterParent {

    public CalculatedChartRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, CalculatedChartRequest.class);
    }
}
