package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.MoviesController;

public class ReturnMovieAction implements MenuItemAction {
    private MoviesController moviesController;

    public ReturnMovieAction(MoviesController moviesController) {
        this.moviesController = moviesController;
    }

    @Override
    public void performAction() {
        moviesController.returnAMovie();
    }
}