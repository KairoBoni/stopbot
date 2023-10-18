package com.kairoboni.stopbot.app.http.controllers.search;

import com.kairoboni.stopbot.app.adapters.packages.search.themes.ThemesSuggestionsPgsqlAdapter;
import com.kairoboni.stopbot.app.dependencies.exeptions.http.InternalServerErrorException;
import com.kairoboni.stopbot.app.dependencies.logger.BaseLogger;
import com.kairoboni.stopbot.app.models.ThemesSuggestionsRepository;
import com.kairoboni.stopbot.core.packages.search.themes.UsaCase;
import com.kairoboni.stopbot.core.packages.search.themes.requests.Request;
import com.kairoboni.stopbot.core.packages.search.themes.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final BaseLogger logger = new BaseLogger(Service.class);

    @Autowired
    private ThemesSuggestionsRepository themesSuggestionsRepository;

    public Response themes(char startLetter, String themes) {
        try {
            List<String> themesList = new ArrayList<String>(Arrays.asList(themes.split(",")));
            Request request = new Request(
                    startLetter,
                    themesList
            );
            this.logger.info("[themes] Init service");
            UsaCase useCase = new UsaCase(
                    this.logger,
                    new ThemesSuggestionsPgsqlAdapter(themesSuggestionsRepository)
            );

            this.logger.info("[themes] Finish service");
            return useCase.execute(request);
        } catch (Throwable th) {
            throw new InternalServerErrorException("[themes] Error to execute service");
        }
    }
}
