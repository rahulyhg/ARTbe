package com.kampherbeek.art.json.converters;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.representation.ResponseInterface;
import lombok.NonNull;

import java.io.IOException;

public abstract class ConverterParent {

    ObjectMapper mapper = new ObjectMapper();


    public abstract RequestInterface jsonRequest2Java(@NonNull final String input) throws IOException;

    public String java2JsonResponse(@NonNull final ResponseInterface response) throws JsonProcessingException {
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(response);
    }

    public String java2JsonRequest(@NonNull final RequestInterface request) throws JsonProcessingException {
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(request);
    }
}
