package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.BodyPositionHandler;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bodyposition")
public class BodyPositionController {

    private final BodyPositionHandler handler;

    @Autowired
    public BodyPositionController(@NonNull final BodyPositionHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String retrieveBodyPosition(@RequestParam(value = "json") String json) {
        return handler.handleRequest(json);
    }
}
