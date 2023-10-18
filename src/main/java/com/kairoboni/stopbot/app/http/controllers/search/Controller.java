package com.kairoboni.stopbot.app.http.controllers.search;


import com.kairoboni.stopbot.core.packages.search.themes.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
public final class Controller {
    @Autowired
    private Service service;
    @GetMapping
    public Response themes(
            @RequestParam("firstLetter") char startLetter,
            @RequestParam("themes") String themes
    ) {
        return service.themes(startLetter, themes);
    }
}
