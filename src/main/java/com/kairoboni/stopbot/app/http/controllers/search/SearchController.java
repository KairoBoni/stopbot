package com.kairoboni.stopbot.app.http.controllers.search;

import com.kairoboni.stopbot.core.packages.search.suggestions.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
public final class SearchController {
    @Autowired
    private SearchService service;
    @GetMapping(value = "/suggestions")
    public Response suggestions(
            @RequestParam("firstLetter") char startLetter,
            @RequestParam("themes") String themes
    ) {
        return service.suggestions(startLetter, themes);
    }
}
