package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.BodynamesJsonConverter;
import com.kampherbeek.art.json.representation.BodynamesRequest;
import com.kampherbeek.art.json.representation.BodynamesResponse;
import com.kampherbeek.art.json.validators.LookupListValidator;
import com.kampherbeek.art.solvers.BodynamesSolver;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BodynamesHandler {

    private static final Logger LOG = LoggerFactory.getLogger(BodynamesHandler.class);
    private final LookupListValidator validator;
    private final BodynamesJsonConverter converter;
    private final BodynamesSolver solver;

    @Autowired
    public BodynamesHandler(@NonNull final LookupListValidator validator,
                            @NonNull final BodynamesJsonConverter converter,
                            @NonNull final BodynamesSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(@NonNull String requestJson) {

        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        String ERROR_TEXT = "Error in BodynamesHandler";
        if (validatedObject.isValid()) {
            BodynamesResponse response = solver.solveRequest((BodynamesRequest) validatedObject.getObject());
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
