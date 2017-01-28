package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.EpsilonHandler;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/epsilon")
public class EpsilonController {

    private final EpsilonHandler handler;

    @Autowired
    public EpsilonController(@NonNull EpsilonHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String retrieveEpsilon(@RequestParam(value = "json") String json) {
        return handler.handleRequest(json);
    }
}

