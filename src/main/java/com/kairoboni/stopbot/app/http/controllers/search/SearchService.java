package com.kairoboni.stopbot.app.http.controllers.search;

import com.kairoboni.stopbot.app.adapters.packages.search.suggestions.ThemesSuggestionsPgsqlAdapter;
import com.kairoboni.stopbot.app.dependencies.exeptions.factory.FactoryException;
import com.kairoboni.stopbot.app.dependencies.exeptions.http.InternalServerErrorException;
import com.kairoboni.stopbot.app.dependencies.exeptions.http.UnprocessableEntityException;
import com.kairoboni.stopbot.app.dependencies.logger.BaseLogger;
import com.kairoboni.stopbot.app.factory.search.suggestions.CreateRequest;
import com.kairoboni.stopbot.app.models.ThemesSuggestionsRepository;
import com.kairoboni.stopbot.core.packages.search.suggestions.UseCase;
import com.kairoboni.stopbot.core.packages.search.suggestions.requests.Request;
import com.kairoboni.stopbot.core.packages.search.suggestions.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class SearchService {
    private final BaseLogger logger = new BaseLogger(SearchService.class);

    @Autowired
    private ThemesSuggestionsRepository themesSuggestionsRepository;

    public Response suggestions(char startLetter, String themes) {
        try {
            this.logger.info("[suggestions] Init service");
            UseCase useCase = new UseCase(
                    this.logger,
                    new ThemesSuggestionsPgsqlAdapter(themesSuggestionsRepository)
            );

            Request request = CreateRequest.make(startLetter, themes);
            Response response = useCase.execute(request);
            this.logger.info("[suggestions] Finish service");

            return response;

        } catch (FactoryException $th) {
            UnprocessableEntityException th = new UnprocessableEntityException();
            this.logger.error("[suggestions] Bad formatter of startLetter %s or list of themes %s", th, startLetter, themes);
            throw th;
        } catch (Throwable th) {
            throw new InternalServerErrorException();
        }
    }
}
