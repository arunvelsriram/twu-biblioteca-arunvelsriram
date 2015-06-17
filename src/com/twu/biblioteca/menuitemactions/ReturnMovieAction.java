package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Section;

import java.util.List;

import static com.twu.biblioteca.constants.Constants.MOVIE_RETURN_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.MOVIE_RETURN_SUCCESS_MESSAGE;

public class ReturnMovieAction implements MenuItemAction {
    private ItemController itemController;
    private Section moviesSection;

    public ReturnMovieAction(ItemController itemController, Section moviesSection) {
        this.itemController = itemController;
        this.moviesSection = moviesSection;
    }

    @Override
    public void performAction() {
        List<Item> items = itemController.searchIssuedItems(moviesSection);
        for(Item item : items) {
            itemController.returnAnItem(moviesSection, item);
            itemController.result(MOVIE_RETURN_SUCCESS_MESSAGE);
            return;
        }
        itemController.result(MOVIE_RETURN_FAILURE_MESSAGE);
    }
}