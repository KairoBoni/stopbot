package com.kairoboni.stopbot.app.adapters.packages.list.themes;

import com.kairoboni.stopbot.app.models.ThemesSuggestionsRepository;
import com.kairoboni.stopbot.core.packages.list.themes.gateways.ThemeSuggestionGateway;

import java.util.*;

public class ThemesSuggestionsPgsqlAdapter implements ThemeSuggestionGateway {
    private final ThemesSuggestionsRepository themesSuggestionsRepository;

    public ThemesSuggestionsPgsqlAdapter(ThemesSuggestionsRepository themesSuggestionsRepository) {
        this.themesSuggestionsRepository = themesSuggestionsRepository;
    }

    @Override
    public List<String> getAllThemes() {
        return this.themesSuggestionsRepository.findAllThemes();
    }
}
