package com.kairoboni.stopbot.core.packages.search.suggestions.requests;

import java.util.List;

public class Request {
    private final char firstLetter;
    private final List<String> themes;

    public Request(char firstLetter, List<String> themes) {
        this.themes = themes;
        this.firstLetter = firstLetter;
    }
    public List<String> getThemes() {
        return themes;
    }

    public char getFirstLetter() {
        return firstLetter;
    }
}
