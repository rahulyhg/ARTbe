package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.VersionHandler;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/version")
public class VersionController {

    private final VersionHandler handler;
    private static final String SHORTVALUE = "{\"versionType\":\"full\"}";

    @Autowired
    public VersionController(@NonNull VersionHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String retrieveVersion(@RequestParam(value = "json", required = false, defaultValue = SHORTVALUE) String json) {
        return handler.handleRequest(json);
    }
}
