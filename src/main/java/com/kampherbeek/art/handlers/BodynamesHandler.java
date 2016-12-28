package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.BodynamesJsonConverter;
import com.kampherbeek.art.json.representation.BodynamesRequest;
import com.kampherbeek.art.json.representation.BodynamesResponse;
import com.kampherbeek.art.json.validators.LookupListValidator;
import com.kampherbeek.art.solvers.BodynamesSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BodynamesHandler {

    private final LookupListValidator validator;
    private final BodynamesJsonConverter converter;
    private final BodynamesSolver solver;

    private final String ERROR_TEXT = "Error in BodynamesHandler";

@Autowired
    public BodynamesHandler(final LookupListValidator validator,
                            final BodynamesJsonConverter converter,
                            final BodynamesSolver solver) {
    this.validator = validator;
    this.converter = converter;
    this.solver = solver;
}


    public String handleRequest(String requestJson) {

        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        if (validatedObject.isValid()) {
            BodynamesResponse response = solver.solveRequest((BodynamesRequest) validatedObject.getObject());
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                return ERROR_TEXT;
            }
        }
        return ERROR_TEXT;
    }


}


/*



 */