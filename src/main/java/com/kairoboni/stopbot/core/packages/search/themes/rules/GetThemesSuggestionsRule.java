package com.kairoboni.stopbot.core.packages.search.themes.rules;

import com.kairoboni.stopbot.core.packages.search.themes.entities.ThemeSuggestion;
import com.kairoboni.stopbot.core.packages.search.themes.gateways.ThemeSuggestionGateway;

import java.util.List;

public class GetThemesSuggestionsRule {
    private final ThemeSuggestionGateway themeSuggestionGateway;

    public GetThemesSuggestionsRule(ThemeSuggestionGateway themeSuggestionGateway) {
        this.themeSuggestionGateway = themeSuggestionGateway;
    }

    public List<ThemeSuggestion> apply(List<String> themes) {
        return this.themeSuggestionGateway.get(themes);
    }
}
