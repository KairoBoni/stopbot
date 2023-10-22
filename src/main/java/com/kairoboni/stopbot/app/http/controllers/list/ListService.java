package com.kairoboni.stopbot.app.http.controllers.list;

import com.kairoboni.stopbot.app.adapters.packages.list.themes.ThemesSuggestionsPgsqlAdapter;
import com.kairoboni.stopbot.app.dependencies.exeptions.http.InternalServerErrorException;
import com.kairoboni.stopbot.app.dependencies.logger.BaseLogger;
import com.kairoboni.stopbot.app.models.ThemesSuggestionsRepository;
import com.kairoboni.stopbot.core.packages.list.themes.UseCase;
import com.kairoboni.stopbot.core.packages.list.themes.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ListService {
    private final BaseLogger logger = new BaseLogger(ListService.class);

    @Autowired
    private ThemesSuggestionsRepository themesSuggestionsRepository;

    public Response themes() {
        try {
            this.logger.info("[themes] Init service");
            UseCase useCase = new UseCase(
                    this.logger,
                    new ThemesSuggestionsPgsqlAdapter(themesSuggestionsRepository)
            );

            Response response = useCase.execute();
            this.logger.info("[themes] Finish service");

            return response;

        }  catch (Throwable th) {
            throw new InternalServerErrorException();
        }
    }
}
