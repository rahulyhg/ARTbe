package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.SingleCyclesHandler;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/singlecycles")
public class SingleCyclesController {

    private final SingleCyclesHandler handler;

    @Autowired
    public SingleCyclesController(@NonNull SingleCyclesHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String retrieveCycleValues(@RequestParam(value = "json") String json) {
        return handler.handleRequest(json);
    }
}
