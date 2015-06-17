package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Section;

import static com.twu.biblioteca.constants.Constants.MOVIE_CHECKOUT_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.MOVIE_CHECKOUT_SUCCESS_MESSAGE;

public class CheckoutMovieAction implements MenuItemAction {

    private ItemController itemController;
    private Section movieSection;

    public CheckoutMovieAction(ItemController itemController, Section movieSection) {
        this.itemController = itemController;
        this.movieSection = movieSection;
    }

    @Override
    public void performAction() {
        itemController.checkoutAnItem(movieSection, MOVIE_CHECKOUT_SUCCESS_MESSAGE, MOVIE_CHECKOUT_FAILURE_MESSAGE);
    }
}