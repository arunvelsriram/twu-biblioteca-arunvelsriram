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

    public void checkoutAMovie() {
        String title = view.read();
        if(moviesSection.checkoutItem(title)) {
            view.write("Thank you! Enjoy the movie.");
        }
        else {
            view.write("That movie is not available.");
        }
    }

    public void returnAMovie() {
        String title = view.read();
        if(moviesSection.returnItem(title)) {
            view.write("Thank you for returning the movie.");
        }
        else {
            view.write("That is not a valid movie to return.");
        }
    }
}