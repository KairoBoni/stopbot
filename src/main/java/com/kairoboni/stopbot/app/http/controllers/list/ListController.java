package com.kairoboni.stopbot.app.http.controllers.list;

import com.kairoboni.stopbot.core.packages.list.themes.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
public final class ListController {
    @Autowired
    private ListService service;
    @GetMapping(value = "/themes")
    public Response themes() {
        return service.themes();
    }
}