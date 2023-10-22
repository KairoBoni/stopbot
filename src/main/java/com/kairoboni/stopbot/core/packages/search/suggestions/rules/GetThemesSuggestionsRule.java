package com.kairoboni.stopbot.core.packages.search.suggestions.rules;

import com.kairoboni.stopbot.core.packages.search.suggestions.entities.ThemeSuggestion;
import com.kairoboni.stopbot.core.packages.search.suggestions.exceptions.GetThemesSuggestionsException;
import com.kairoboni.stopbot.core.packages.search.suggestions.gateways.ThemeSuggestionGateway;

import java.util.List;

public class GetThemesSuggestionsRule {
    private final ThemeSuggestionGateway themeSuggestionGateway;

    public GetThemesSuggestionsRule(ThemeSuggestionGateway themeSuggestionGateway) {
        this.themeSuggestionGateway = themeSuggestionGateway;
    }

    public List<ThemeSuggestion> apply(char firstLetter, List<String> themes) {
        try{
            return this.themeSuggestionGateway.get(firstLetter, themes);
        } catch (Throwable th) {
            throw new GetThemesSuggestionsException(th);
        }
    }
}
