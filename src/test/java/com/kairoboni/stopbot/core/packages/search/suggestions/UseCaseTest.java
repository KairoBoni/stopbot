package com.kairoboni.stopbot.core.packages.search.suggestions;

import com.kairoboni.stopbot.core.dependencies.LoggerInterface;
import com.kairoboni.stopbot.core.packages.search.suggestions.entities.ThemeSuggestion;
import com.kairoboni.stopbot.core.packages.search.suggestions.exceptions.GetThemesSuggestionsException;
import com.kairoboni.stopbot.core.packages.search.suggestions.gateways.ThemeSuggestionGateway;
import com.kairoboni.stopbot.core.packages.search.suggestions.requests.Request;
import com.kairoboni.stopbot.core.packages.search.suggestions.responses.Response;
import com.kairoboni.stopbot.core.packages.search.suggestions.rules.GetThemesSuggestionsRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class UseCaseTest {
    @Mock
    private ThemeSuggestionGateway themeSuggestionGateway;
    @Mock
    private LoggerInterface logger;
    private List<String> themes;
    private char firstLetter;
    private List<ThemeSuggestion> themesSuggestion;

    private UseCase useCase;
    @BeforeEach
    void SetUp() {
        MockitoAnnotations.openMocks(this);
        themes = new ArrayList<>();
        themes.add("theme1");
        themes.add("theme2");

        firstLetter = 't';

        themesSuggestion = new ArrayList<ThemeSuggestion>();

        themesSuggestion.add(new ThemeSuggestion("theme1", "teste1"));
        themesSuggestion.add(new ThemeSuggestion("theme2", "teste2"));

        useCase = new UseCase(this.logger, this.themeSuggestionGateway);

    }

    @Test
    void testApplySuccessful()  {
        Mockito.when(themeSuggestionGateway.get(this.firstLetter, this.themes)).thenReturn(themesSuggestion);

        Response response = useCase.execute(
                new Request(this.firstLetter, this.themes)
        );

        assertArrayEquals(this.themesSuggestion.toArray(), response.getThemesSuggestions().toArray());
        Mockito.verify(themeSuggestionGateway, Mockito.times(1)).get(this.firstLetter, this.themes);
    }

    @Test
    void testApplyException() {
        Mockito.when(themeSuggestionGateway.get(this.firstLetter, this.themes)).thenThrow(MockitoException.class);

        assertThrows(GetThemesSuggestionsException.class, () -> {
            useCase.execute(
                    new Request(this.firstLetter, this.themes)
            );
        });
    }
}
