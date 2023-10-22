package com.kairoboni.stopbot.core.packages.search.suggestions.gateways;

import com.kairoboni.stopbot.core.packages.search.suggestions.entities.ThemeSuggestion;

import java.util.List;

public interface ThemeSuggestionGateway {
    public List<ThemeSuggestion> get(char firstLetter, List<String> themes) throws Exception;
}
