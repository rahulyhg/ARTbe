package com.kampherbeek.art.json.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import com.kampherbeek.art.json.representation.HouseSystemsResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HouseSystemsJsonConverter {

    ObjectMapper mapper = new ObjectMapper();

    public HouseSystemsRequest jsonRequest2Java(String input) throws IOException {
        return mapper.readValue(input, HouseSystemsRequest.class);
    }

    public String java2JsonResponse(HouseSystemsResponse houseSystemsResponse) throws JsonProcessingException {
        return mapper.writeValueAsString(houseSystemsResponse);
    }

}
