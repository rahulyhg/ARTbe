package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.BodyPositionJsonConverter;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.BodyPositionResponse;
import com.kampherbeek.art.json.validators.BodyPositionValidator;
import com.kampherbeek.art.solvers.BodyPositionSolver;
import lombok.NonNull;
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

    @Autowired
    public BodyPositionHandler(@NonNull BodyPositionValidator validator,
                               @NonNull BodyPositionJsonConverter converter,
                               @NonNull BodyPositionSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(@NonNull String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        String errorText = "Error in BodyPositionHandler";
        if (validatedObject.isValid()) {
            BodyPositionResponse response = solver.solveRequest((BodyPositionRequest) validatedObject.getObject());
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                LOG.error(errorText + ": " + e);
                return errorText;
            }
        }
        return errorText;
    }
}
