package com.kairoboni.stopbot.app.adapters.packages.search.themes;

import com.kairoboni.stopbot.app.models.ThemesSuggestionsModel;
import com.kairoboni.stopbot.app.models.ThemesSuggestionsRepository;
import com.kairoboni.stopbot.core.packages.search.themes.entities.ThemeSuggestion;
import com.kairoboni.stopbot.core.packages.search.themes.gateways.ThemeSuggestionGateway;

import java.util.*;

public class ThemesSuggestionsPgsqlAdapter implements ThemeSuggestionGateway {
    private final ThemesSuggestionsRepository themesSuggestionsRepository;

    public ThemesSuggestionsPgsqlAdapter(ThemesSuggestionsRepository themesSuggestionsRepository) {
        this.themesSuggestionsRepository = themesSuggestionsRepository;
    }

    public List<ThemeSuggestion> get(char firstLetter, List<String> themes) throws Exception {
        List<ThemesSuggestionsModel> themesSuggestionModel = themesSuggestionsRepository.findByThemeInAndFirstLetter(themes, firstLetter);
        Collections.shuffle(themesSuggestionModel);

        Map<String, ThemesSuggestionsModel> selectedSuggestions = new HashMap<>();
        List<ThemeSuggestion> themeSuggestion = new ArrayList<>();

        for (ThemesSuggestionsModel suggestion : themesSuggestionModel) {
            String theme = suggestion.getTheme();
            if (!selectedSuggestions.containsKey(theme)) {
                selectedSuggestions.put(theme, suggestion);
                themeSuggestion.add(
                        new ThemeSuggestion(theme, suggestion.getSuggestion())
                );
            }
        }
        return themeSuggestion;
    }

}
