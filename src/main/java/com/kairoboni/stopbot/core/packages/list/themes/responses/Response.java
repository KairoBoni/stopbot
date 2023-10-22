package com.kairoboni.stopbot.core.packages.list.themes.responses;

import java.util.List;

public class Response {
    private List<String> themes;

    public Response(List<String> themes) {
        this.themes = themes;
    }

    public List<String> getThemes() {
        return themes;
    }
}
