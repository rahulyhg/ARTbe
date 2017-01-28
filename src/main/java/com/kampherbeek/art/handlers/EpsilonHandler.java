package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.EpsilonJsonConverter;
import com.kampherbeek.art.json.representation.EpsilonRequest;
import com.kampherbeek.art.json.representation.EpsilonResponse;
import com.kampherbeek.art.json.validators.EpsilonValidator;
import com.kampherbeek.art.solvers.EpsilonSolver;
import lombok.NonNull;
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

    @Autowired
    public EpsilonHandler(@NonNull EpsilonValidator validator,
                          @NonNull EpsilonJsonConverter converter,
                          @NonNull EpsilonSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(@NonNull String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        String errorText = "Error in EpsilonHandler";
        if (validatedObject.isValid()) {
            EpsilonResponse response = solver.solveRequest((EpsilonRequest) validatedObject.getObject());
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
