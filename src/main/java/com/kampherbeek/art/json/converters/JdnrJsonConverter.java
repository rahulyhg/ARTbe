package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.JdnrRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JdnrJsonConverter extends ConverterParent{

    public JdnrRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, JdnrRequest.class);
    }


}
