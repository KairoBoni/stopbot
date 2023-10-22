package com.kairoboni.stopbot.core.packages.list.themes;

import com.kairoboni.stopbot.core.dependencies.LoggerInterface;
import com.kairoboni.stopbot.core.packages.list.themes.gateways.ThemeSuggestionGateway;
import com.kairoboni.stopbot.core.packages.list.themes.responses.Response;
import com.kairoboni.stopbot.core.packages.list.themes.rules.GetThemesRule;

public class UseCase {
    private final GetThemesRule getThemesRule;
    private final LoggerInterface logger;

    public UseCase(
            LoggerInterface logger,
            ThemeSuggestionGateway themeSuggestionGateway
    ) {
        this.logger = logger;
        this.getThemesRule = new GetThemesRule(themeSuggestionGateway);
    }

    public Response execute() {
        try {
            this.logger.info("[list:themes::UseCase] Init UseCase");
            return new Response(this.getThemesRule.apply());
        } catch (Throwable th) {
            this.logger.error("[list:themes::UseCase] Error on execute UseCase", th);
            throw th;
        }
    }
}
