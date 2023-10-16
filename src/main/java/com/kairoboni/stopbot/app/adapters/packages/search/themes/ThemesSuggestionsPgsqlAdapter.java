package com.kairoboni.stopbot.app.adapters.packages.search.themes;

import com.kairoboni.stopbot.core.packages.search.themes.entities.ThemeSuggestion;
import com.kairoboni.stopbot.core.packages.search.themes.gateways.ThemeSuggestionGateway;

import java.util.ArrayList;
import java.util.List;

public class ThemesSuggestionsPgsqlAdapter implements ThemeSuggestionGateway {
    @Override
    public List<ThemeSuggestion> get(List<String> themes) throws Exception {
        throw new Exception();
//        List<ThemeSuggestion> themesSuggestions = new ArrayList<>();
//        themesSuggestions.add(new ThemeSuggestion("Carro", "Voyage"));
//
//        return themesSuggestions;
    }
}
