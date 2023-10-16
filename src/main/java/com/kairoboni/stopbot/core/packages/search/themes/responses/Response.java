package com.kairoboni.stopbot.core.packages.search.themes.responses;

import com.kairoboni.stopbot.core.packages.search.themes.entities.ThemeSuggestion;

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
