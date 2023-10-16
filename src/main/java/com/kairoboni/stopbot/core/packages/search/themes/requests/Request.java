package com.kairoboni.stopbot.core.packages.search.themes.requests;

import java.util.ArrayList;
import java.util.List;

public class Request {
    private final List<String> themes;

    public Request(List<String> themes) {
        this.themes = themes;
    }
    public List<String> getThemes() {
        return themes;
    }
}
