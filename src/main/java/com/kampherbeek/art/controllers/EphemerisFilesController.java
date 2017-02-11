package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.EphemerisFilesHandler;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ephemerisfiles")
public class EphemerisFilesController {

    private final EphemerisFilesHandler handler;

    @Autowired
    public EphemerisFilesController(@NonNull EphemerisFilesHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String retrieveEphemerisFiles() {
        return handler.handleRequest();
    }

}
