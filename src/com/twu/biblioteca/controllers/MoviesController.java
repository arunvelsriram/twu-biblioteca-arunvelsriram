package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.View;

public class MoviesController {
    private Section moviesSection;
    private View view;

    public MoviesController(Section moviesSection, View view) {
        this.moviesSection = moviesSection;
        this.view = view;
    }

    public void listAvailableMovies() {
        String movieDetails = moviesSection.availableItems();
        view.write(movieDetails);
    }
}