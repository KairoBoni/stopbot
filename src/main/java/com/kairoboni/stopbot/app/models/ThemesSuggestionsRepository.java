package com.kairoboni.stopbot.app.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemesSuggestionsRepository extends JpaRepository<ThemesSuggestionsModel, Long> {
    List<ThemesSuggestionsModel> findByThemeInAndFirstLetter(List<String> theme, char firstLetter);

    @Query("SELECT theme FROM ThemesSuggestionsModel GROUP BY theme")
    List<String> findAllThemes();
}
