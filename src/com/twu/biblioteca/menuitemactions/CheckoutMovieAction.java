package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Section;

import java.util.List;

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
        List<Item> items = itemController.searchAvailableItems(movieSection);
        for(Item item : items) {
            itemController.checkoutAnItem(movieSection, item);
            itemController.result(MOVIE_CHECKOUT_SUCCESS_MESSAGE);
            return;
        }
        itemController.result(MOVIE_CHECKOUT_FAILURE_MESSAGE);
    }
}