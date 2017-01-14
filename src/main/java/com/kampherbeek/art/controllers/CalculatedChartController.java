package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.CalculatedChartHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/calculatedchart")
public class CalculatedChartController {

    private final CalculatedChartHandler handler;

    @Autowired
    public CalculatedChartController(CalculatedChartHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String getCalculatedChart(@RequestParam(value = "json") String json) {
        return handler.handleRequest(json);
    }
}

