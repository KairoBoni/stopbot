package com.kairoboni.stopbot.core.packages.list.themes.rules;



import com.kairoboni.stopbot.core.packages.list.themes.exceptions.GetThemesSuggestionsException;
import com.kairoboni.stopbot.core.packages.list.themes.gateways.ThemeSuggestionGateway;

import java.util.List;

public class GetThemesRule {
    private final ThemeSuggestionGateway themeSuggestionGateway;

    public GetThemesRule(ThemeSuggestionGateway themeSuggestionGateway) {
        this.themeSuggestionGateway = themeSuggestionGateway;
    }

    public List<String> apply() {
        try{
            return this.themeSuggestionGateway.getAllThemes();
        } catch (Throwable th) {
            throw new GetThemesSuggestionsException(th);
        }
    }
}
