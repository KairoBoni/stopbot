package com.kairoboni.stopbot.core.packages.search.themes;

import com.kairoboni.stopbot.core.packages.search.themes.gateways.ThemeSuggestionGateway;
import com.kairoboni.stopbot.core.packages.search.themes.requests.Request;
import com.kairoboni.stopbot.core.packages.search.themes.responses.Response;
import com.kairoboni.stopbot.core.packages.search.themes.rules.GetThemesSuggestionsRule;

public class UsaCase {
    private final GetThemesSuggestionsRule getThemesSuggestionsRule;

    public UsaCase(ThemeSuggestionGateway themeSuggestionGateway) {
        this.getThemesSuggestionsRule = new GetThemesSuggestionsRule(themeSuggestionGateway);
    }

    public Response execute(Request request) {
        return new Response(this.getThemesSuggestionsRule.apply(request.getThemes()));
    }
}
