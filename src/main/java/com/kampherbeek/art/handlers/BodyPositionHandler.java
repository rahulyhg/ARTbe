package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.BodyPositionJsonConverter;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.BodyPositionResponse;
import com.kampherbeek.art.json.validators.BodyPositionValidator;
import com.kampherbeek.art.solvers.BodyPositionSolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BodyPositionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(BodyPositionHandler.class);
    private final BodyPositionValidator validator;
    private final BodyPositionJsonConverter converter;
    private final BodyPositionSolver solver;
    private final String ERROR_TEXT = "Error in BodyPositionHandler";

    @Autowired
    public BodyPositionHandler(BodyPositionValidator validator, BodyPositionJsonConverter converter,
                               BodyPositionSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        if (validatedObject.isValid()) {
            BodyPositionResponse response =  solver.solveRequest((BodyPositionRequest) validatedObject.getObject());
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                LOG.error(ERROR_TEXT + ": " + e.getMessage());
                return ERROR_TEXT;
            }
        }
        return ERROR_TEXT;
    }

}
