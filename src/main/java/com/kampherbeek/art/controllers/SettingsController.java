package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.SettingsHandler;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    private final SettingsHandler handler;

    @Autowired
    public SettingsController(@NonNull SettingsHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String retrieveSettings() {
        return handler.handleRequest();
    }

}

