package com.kampherbeek.art.solvers;

import com.kampherbeek.art.calc.JdnrCalculator;
import com.kampherbeek.art.json.representation.JdnrRequest;
import com.kampherbeek.art.json.representation.JdnrResponse;
import org.springframework.stereotype.Component;

@Component
public class JdnrSolver {

    private final JdnrCalculator calculator;

    public JdnrSolver(JdnrCalculator calculator) {
        this.calculator = calculator;
    }

    public JdnrResponse solveResponse(JdnrRequest request) {
        JdnrResponse response = new JdnrResponse();
        response.setJdnr(calculator.calcJd(request));
        return response;
    }
}
