package com.kairoboni.stopbot.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "themes_suggestions")
public class ThemesSuggestionsModel {
    @Id
    private Long id;
    @Column(nullable = false)
    private String theme;
    @Column(nullable = false)
    private String suggestion;
    @Column(name = "first_letter", nullable = false)
    private char firstLetter;

    public Long getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public char getFirstLetter() {
        return firstLetter;
    }
}

