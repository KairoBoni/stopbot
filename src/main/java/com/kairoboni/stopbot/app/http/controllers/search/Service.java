package com.kairoboni.stopbot.app.http.controllers.search;

import com.kairoboni.stopbot.app.adapters.packages.search.themes.ThemesSuggestionsPgsqlAdapter;
import com.kairoboni.stopbot.app.dependencies.exeptions.http.InternalServerErrorException;
import com.kairoboni.stopbot.app.dependencies.logger.BaseLogger;
import com.kairoboni.stopbot.core.packages.search.themes.UsaCase;
import com.kairoboni.stopbot.core.packages.search.themes.requests.Request;
import com.kairoboni.stopbot.core.packages.search.themes.responses.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class Service {
    private final BaseLogger logger = new BaseLogger(Service.class);

    public Response themes() {
        try {
            this.logger.info("[themes] Init service");
            ArrayList<String> themes = new ArrayList<String>();
            themes.add("Theme 1");
            themes.add("Theme 2");
            Request request = new Request(themes);
            UsaCase useCase = new UsaCase(
                    this.logger,
                    new ThemesSuggestionsPgsqlAdapter()
            );

            this.logger.info("[themes] Finish service");
            return useCase.execute(request);
        } catch (Throwable th) {
            throw new InternalServerErrorException("[themes] Error to execute service");
        }
    }
}
