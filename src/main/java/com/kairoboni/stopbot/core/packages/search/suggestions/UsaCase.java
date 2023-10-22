package com.kairoboni.stopbot.core.packages.search.suggestions;

import com.kairoboni.stopbot.core.dependencies.LoggerInterface;
import com.kairoboni.stopbot.core.packages.search.suggestions.gateways.ThemeSuggestionGateway;
import com.kairoboni.stopbot.core.packages.search.suggestions.requests.Request;
import com.kairoboni.stopbot.core.packages.search.suggestions.responses.Response;
import com.kairoboni.stopbot.core.packages.search.suggestions.rules.GetThemesSuggestionsRule;

public class UsaCase {
    private final GetThemesSuggestionsRule getThemesSuggestionsRule;
    private final LoggerInterface logger;

    public UsaCase(
            LoggerInterface logger,
            ThemeSuggestionGateway themeSuggestionGateway
    ) {
        this.logger = logger;
        this.getThemesSuggestionsRule = new GetThemesSuggestionsRule(themeSuggestionGateway);
    }

    public Response execute(Request request) {
        try {
            this.logger.info("[search:suggestions::UseCase] Init UseCase: \n{\nthemes: %s,\n}\n", request.getThemes());
            return new Response(this.getThemesSuggestionsRule.apply(
                    request.getFirstLetter(),
                    request.getThemes()
            ));
        } catch (Throwable th) {
            this.logger.error("[search:suggestions::UseCase] Error on execute UseCase: \n{\nthemes: %s,\n}\n", th, request.getThemes());
            throw th;
        }
    }
}
