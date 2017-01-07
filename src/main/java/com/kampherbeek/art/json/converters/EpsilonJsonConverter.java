package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.EpsilonRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EpsilonJsonConverter extends ConverterParent {

    public EpsilonRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, EpsilonRequest.class);
    }

}
