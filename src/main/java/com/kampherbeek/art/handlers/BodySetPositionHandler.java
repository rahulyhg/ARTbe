package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.BodySetPositionJsonConverter;
import com.kampherbeek.art.json.representation.BodySetPositionRequest;
import com.kampherbeek.art.json.representation.BodySetPositionResponse;
import com.kampherbeek.art.json.validators.BodySetPositionValidator;
import com.kampherbeek.art.solvers.BodySetPositionSolver;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BodySetPositionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(BodySetPositionHandler.class);

    private final BodySetPositionValidator validator;
    private final BodySetPositionJsonConverter converter;
    private final BodySetPositionSolver solver;

    @Autowired
    public BodySetPositionHandler(@NonNull BodySetPositionValidator validator,
                                  @NonNull BodySetPositionJsonConverter converter,
                                  @NonNull BodySetPositionSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(@NonNull String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        String errorText = "Error in BodySetPositionHandler";
        if (validatedObject.isValid()) {
            BodySetPositionResponse response = solver.solveRequest((BodySetPositionRequest) validatedObject.getObject());
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

