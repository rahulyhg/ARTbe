package com.kampherbeek.art.json.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class VersionJsonConverter {

    ObjectMapper mapper = new ObjectMapper();

    public VersionRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, VersionRequest.class);
    }

    public String java2JsonResponse(VersionResponse versionResponse) throws JsonProcessingException {
        return mapper.writeValueAsString(versionResponse);
    }

}
