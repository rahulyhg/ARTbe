package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.VersionJsonConverter;
import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import com.kampherbeek.art.json.validators.VersionValidator;
import com.kampherbeek.art.solvers.VersionSolver;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VersionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(VersionHandler.class);
    private final VersionValidator validator;
    private final VersionJsonConverter converter;
    private final VersionSolver solver;

    @Autowired
    public VersionHandler(@NonNull final VersionValidator validator,
                          @NonNull final VersionJsonConverter converter,
                          @NonNull final VersionSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(@NonNull final String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        String errorText = "Error in VersionHandler";
        if (validatedObject.isValid()) {
            VersionResponse response = solver.solveRequest((VersionRequest) validatedObject.getObject());
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                LOG.error("Exception: " + e);
                return errorText;
            }
        }
        return errorText;
    }
}
