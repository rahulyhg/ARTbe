package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.HouseSystemsJsonConverter;
import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import com.kampherbeek.art.json.representation.HouseSystemsResponse;
import com.kampherbeek.art.json.validators.HouseSystemsValidator;
import com.kampherbeek.art.solvers.HouseSystemsSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseSystemsHandler {

    private final HouseSystemsValidator validator;
    private final HouseSystemsJsonConverter converter;
    private final HouseSystemsSolver solver;
    private final String ERROR_TEXT = "Error in HouseSystemsHandler";

    @Autowired
    public HouseSystemsHandler(final HouseSystemsValidator validator,
                               final HouseSystemsJsonConverter converter,
                               final HouseSystemsSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson);
        if (validatedObject.isValid()) {
            HouseSystemsResponse response = solver.solveRequest((HouseSystemsRequest) validatedObject.getObject());
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                return ERROR_TEXT;
            }
        }
        return ERROR_TEXT;
    }

}
