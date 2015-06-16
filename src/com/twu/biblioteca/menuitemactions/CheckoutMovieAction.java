package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.MoviesController;

public class CheckoutMovieAction implements MenuItemAction {
    private MoviesController moviesController;

    public CheckoutMovieAction(MoviesController moviesController) {
        this.moviesController = moviesController;
    }

    @Override
    public void performAction() {
        moviesController.checkoutAMovie();
    }
}