package com.kairoboni.stopbot.core.packages.search.suggestions.entities;

public class ThemeSuggestion {
    private final String theme;
    private final String suggestion;

    public ThemeSuggestion(String theme, String suggestion) {
        this.theme = theme;
        this.suggestion = suggestion;
    }

    public String getTheme() {
        return theme;
    }

    public String getSuggestion() {
        return suggestion;
    }
}
