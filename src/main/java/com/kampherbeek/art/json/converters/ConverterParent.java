package com.kampherbeek.art.json.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.representation.ResponseInterface;
import lombok.NonNull;

import java.io.IOException;

public abstract class ConverterParent {

    final ObjectMapper mapper = new ObjectMapper();

    public abstract RequestInterface jsonRequest2Java(@NonNull final String input) throws IOException;

    public String java2JsonResponse(@NonNull final ResponseInterface response) throws JsonProcessingException {
        return mapper.writeValueAsString(response);
    }

    public String java2JsonRequest(@NonNull final RequestInterface request) throws JsonProcessingException {
        return mapper.writeValueAsString(request);
    }
}
