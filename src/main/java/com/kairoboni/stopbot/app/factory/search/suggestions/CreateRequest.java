package com.kairoboni.stopbot.app.factory.search.suggestions;

import com.kairoboni.stopbot.app.dependencies.exeptions.factory.FactoryException;
import com.kairoboni.stopbot.core.packages.search.suggestions.requests.Request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateRequest {
    public static Request make(char startLetter, String themes) {
        try {
            List<String> themesList = new ArrayList<String>(Arrays.asList(themes.split(",")));
            return new Request(
                    startLetter,
                    themesList
            );
        } catch (Throwable th) {
            throw new FactoryException(th);
        }
    }
}
