package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.EpsilonJsonConverter;
import com.kampherbeek.art.json.representation.EpsilonRequest;
import com.kampherbeek.art.json.representation.EpsilonResponse;
import com.kampherbeek.art.json.validators.EpsilonValidator;
import com.kampherbeek.art.solvers.EpsilonSolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EpsilonHandler {

    private static final Logger LOG = LoggerFactory.getLogger(EpsilonHandler.class);

    private final EpsilonValidator validator;
    private final EpsilonJsonConverter converter;
    private final EpsilonSolver solver;
    private final String ERROR_TEXT = "Error in EpsilonHandler";

    @Autowired
    public EpsilonHandler(EpsilonValidator validator, EpsilonJsonConverter converter, EpsilonSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        if (validatedObject.isValid()) {
            EpsilonResponse response = solver.solveRequest((EpsilonRequest) validatedObject.getObject());
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                LOG.error("Exception: " + e.getMessage());
                return ERROR_TEXT;
            }
        }
        return ERROR_TEXT;
    }
}
