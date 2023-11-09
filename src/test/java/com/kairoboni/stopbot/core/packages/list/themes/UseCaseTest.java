package com.kairoboni.stopbot.core.packages.list.themes;

import com.kairoboni.stopbot.core.dependencies.LoggerInterface;
import com.kairoboni.stopbot.core.packages.list.themes.exceptions.GetThemesException;
import com.kairoboni.stopbot.core.packages.list.themes.gateways.ThemeSuggestionGateway;
import com.kairoboni.stopbot.core.packages.list.themes.responses.Response;
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

    private UseCase useCase;
    @BeforeEach
    void SetUp() {
        MockitoAnnotations.openMocks(this);
        themes = new ArrayList<>();
        themes.add("theme1");
        themes.add("theme2");


        useCase = new UseCase(this.logger, this.themeSuggestionGateway);

    }

    @Test
    void testApplySuccessful()  {
        Mockito.when(themeSuggestionGateway.getAllThemes()).thenReturn(themes);

        Response response = useCase.execute();

        assertArrayEquals(this.themes.toArray(), response.getThemes().toArray());
        Mockito.verify(themeSuggestionGateway, Mockito.times(1)).getAllThemes();
    }

    @Test
    void testApplyException() {
        Mockito.when(themeSuggestionGateway.getAllThemes()).thenThrow(MockitoException.class);

        assertThrows(GetThemesException.class, () -> {
            useCase.execute();
        });
    }
}
