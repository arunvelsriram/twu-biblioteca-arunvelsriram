package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.MoviesController;

public class ListMoviesAction implements MenuItemAction {
    private MoviesController moviesController;

    public ListMoviesAction(MoviesController moviesController) {
        this.moviesController = moviesController;
    }

    @Override
    public void performAction() {
        moviesController.listAvailableMovies();
    }
}