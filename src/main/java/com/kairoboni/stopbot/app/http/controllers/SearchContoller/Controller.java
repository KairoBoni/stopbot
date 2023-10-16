package com.kairoboni.stopbot.app.http.controllers.SearchContoller;


import com.kairoboni.stopbot.core.packages.search.themes.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public final class Controller {
    @Autowired
    private Service service;
    @GetMapping
    public Response themes() {
        return service.themes();
    }
}
