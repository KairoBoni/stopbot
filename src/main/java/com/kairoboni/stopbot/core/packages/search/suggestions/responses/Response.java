package com.kairoboni.stopbot.core.packages.search.suggestions.responses;

import com.kairoboni.stopbot.core.packages.search.suggestions.entities.ThemeSuggestion;

import java.util.List;

public class Response {
    private final List<ThemeSuggestion> $themesSuggestions;

    public Response(List<ThemeSuggestion> $themesSuggestions) {
        this.$themesSuggestions = $themesSuggestions;
    }

    public List<ThemeSuggestion> get$themesSuggestions() {
        return $themesSuggestions;
    }
}
