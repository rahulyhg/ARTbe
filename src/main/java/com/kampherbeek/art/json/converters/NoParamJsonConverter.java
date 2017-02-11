package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.RequestInterface;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NoParamJsonConverter extends ConverterParent{

    @Override
    public RequestInterface jsonRequest2Java(@NonNull final String input) throws IOException {
        return null;
    }


}

