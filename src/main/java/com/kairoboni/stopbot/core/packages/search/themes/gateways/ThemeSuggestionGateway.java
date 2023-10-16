package com.kairoboni.stopbot.core.packages.search.themes.gateways;

import com.kairoboni.stopbot.core.packages.search.themes.entities.ThemeSuggestion;

import java.util.List;

public interface ThemeSuggestionGateway {
    public List<ThemeSuggestion> get(List<String> themes) throws Exception;
}
