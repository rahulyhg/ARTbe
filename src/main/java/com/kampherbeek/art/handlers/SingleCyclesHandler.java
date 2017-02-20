package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.SingleCyclesJsonConverter;
import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import com.kampherbeek.art.json.representation.SingleCyclesResponse;
import com.kampherbeek.art.json.validators.SingleCyclesValidator;
import com.kampherbeek.art.solvers.SingleCyclesSolver;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleCyclesHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SingleCyclesHandler.class);
    private final SingleCyclesValidator validator;
    private final SingleCyclesJsonConverter converter;
    private final SingleCyclesSolver solver;


    @Autowired
    public SingleCyclesHandler(@NonNull final SingleCyclesValidator validator,
                               @NonNull final SingleCyclesJsonConverter converter,
                               @NonNull final SingleCyclesSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(@NonNull final String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        String errorText = "Error in SingleCyclesHandler";
        if (validatedObject.isValid()) {
            SingleCyclesResponse response = solver.solveRequest((SingleCyclesRequest) validatedObject.getObject());
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                LOG.error("SingleCyclesHandler: " + e);
                return errorText;
            }
        }
        return errorText;
    }


}

