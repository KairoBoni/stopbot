package com.kairoboni.stopbot.app.http.controllers.SearchContoller;

import com.kairoboni.stopbot.app.adapters.packages.search.themes.ThemesSuggestionsPgsqlAdapter;
import com.kairoboni.stopbot.core.packages.search.themes.UsaCase;
import com.kairoboni.stopbot.core.packages.search.themes.requests.Request;
import com.kairoboni.stopbot.core.packages.search.themes.responses.Response;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class Service {

    public Response themes() {
        Request request = new Request(new ArrayList<>());
        UsaCase useCase = new UsaCase(new ThemesSuggestionsPgsqlAdapter());
        return useCase.execute(request);
    }
}
