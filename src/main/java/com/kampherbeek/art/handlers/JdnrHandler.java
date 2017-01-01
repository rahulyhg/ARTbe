package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.JdnrJsonConverter;
import com.kampherbeek.art.json.representation.JdnrRequest;
import com.kampherbeek.art.json.representation.JdnrResponse;
import com.kampherbeek.art.json.validators.JdnrValidator;
import com.kampherbeek.art.solvers.JdnrSolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdnrHandler {

    private static final Logger LOG = LoggerFactory.getLogger(JdnrHandler.class);
    private final JdnrValidator validator;
    private final JdnrJsonConverter converter;
    private final JdnrSolver solver;
    private final String ERROR_TEXT = "Error in JdnrHandler";

    @Autowired
    public JdnrHandler(JdnrValidator validator, JdnrJsonConverter converter, JdnrSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        if (validatedObject.isValid()) {
            JdnrResponse response = solver.solveResponse((JdnrRequest) validatedObject.getObject());
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
