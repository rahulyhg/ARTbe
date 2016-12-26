package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.VersionJsonConverter;
import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import com.kampherbeek.art.json.validators.VersionValidator;
import com.kampherbeek.art.solvers.VersionSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VersionHandler {

    private final VersionValidator validator;
    private final VersionJsonConverter converter;
    private final VersionSolver solver;
    private final String ERROR_TEXT = "Error in VersionHandler";

    @Autowired
    public VersionHandler(VersionValidator validator, VersionJsonConverter converter, VersionSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        if (validatedObject.isValid()) {
            VersionResponse response = solver.solveRequest((VersionRequest) validatedObject.getObject());
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                return ERROR_TEXT;
            }
        }
        return ERROR_TEXT;
    }
}
