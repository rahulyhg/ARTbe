package com.kampherbeek.art.json.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.representation.ResponseInterface;

import java.io.IOException;

public abstract class ConverterParent {

    ObjectMapper mapper = new ObjectMapper();

    public abstract RequestInterface jsonRequest2Java(String input) throws IOException;

    public String java2JsonResponse(ResponseInterface response) throws JsonProcessingException {
        return mapper.writeValueAsString(response);
    }
}
