package com.kairoboni.stopbot.app.http.controllers.SearchContoller;

import com.kairoboni.stopbot.app.adapters.packages.search.themes.ThemesSuggestionsPgsqlAdapter;
import com.kairoboni.stopbot.core.packages.search.themes.UsaCase;
import com.kairoboni.stopbot.core.packages.search.themes.requests.Request;
import com.kairoboni.stopbot.core.packages.search.themes.responses.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class Service {
    private final Logger logger = LoggerFactory.getLogger(Service.class);

    public Response themes() throws Exception {
        Request request = new Request(new ArrayList<>());
        UsaCase useCase = new UsaCase(new ThemesSuggestionsPgsqlAdapter());
        return useCase.execute(request);
    }
}
