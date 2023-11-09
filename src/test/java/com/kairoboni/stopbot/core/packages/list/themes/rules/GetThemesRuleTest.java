package com.kairoboni.stopbot.core.packages.list.themes.rules;

import com.kairoboni.stopbot.core.packages.list.themes.exceptions.GetThemesException;
import com.kairoboni.stopbot.core.packages.list.themes.gateways.ThemeSuggestionGateway;
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

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class GetThemesRuleTest {

    @Mock
    private ThemeSuggestionGateway themeSuggestionGateway;
    private List<String> themes;
    private GetThemesRule getThemesRule;

    @BeforeEach
    void SetUp() {
        MockitoAnnotations.openMocks(this);
        themes = new ArrayList<>();
        themes.add("theme1");
        themes.add("theme2");

        this.getThemesRule= new GetThemesRule(themeSuggestionGateway);
    }

    @Test
    void testApplySuccessful() {
        Mockito.when(themeSuggestionGateway.getAllThemes()).thenReturn(this.themes);

        List<String> result = getThemesRule.apply();

        assertArrayEquals(this.themes.toArray(), result.toArray());
        Mockito.verify(themeSuggestionGateway, Mockito.times(1)).getAllThemes();
    }

    @Test
    void testApplyException() {
        Mockito.when(themeSuggestionGateway.getAllThemes()).thenThrow(MockitoException.class);

        GetThemesRule getThemesRule = new GetThemesRule(themeSuggestionGateway);
        assertThrows(GetThemesException.class, getThemesRule::apply);
    }
}
