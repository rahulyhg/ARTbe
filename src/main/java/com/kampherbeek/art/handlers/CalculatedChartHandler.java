package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.CalculatedChartJsonConverter;
import com.kampherbeek.art.json.representation.CalculatedChartRequest;
import com.kampherbeek.art.json.representation.CalculatedChartResponse;
import com.kampherbeek.art.json.validators.CalculatedChartValidator;
import com.kampherbeek.art.solvers.CalculatedChartSolver;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CalculatedChartHandler {
    private static final Logger LOG = LoggerFactory.getLogger(CalculatedChartHandler.class);

    private final CalculatedChartValidator validator;
    private final CalculatedChartJsonConverter converter;
    private final CalculatedChartSolver solver;

    public CalculatedChartHandler(@NonNull CalculatedChartValidator validator,
                                  @NonNull CalculatedChartJsonConverter converter,
                                  @NonNull CalculatedChartSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(@NonNull String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        String ERROR_TEXT = "Error in CalculatedChartHandler.";
        if (validatedObject.isValid()) {
            CalculatedChartResponse response = solver.solveRequest((CalculatedChartRequest) validatedObject.getObject());
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
