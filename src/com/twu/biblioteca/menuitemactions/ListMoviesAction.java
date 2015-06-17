package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Section;

public class ListMoviesAction implements MenuItemAction {

    private ItemController itemController;
    private Section moviesSection;

    public ListMoviesAction(ItemController itemController, Section moviesSection) {
        this.itemController = itemController;
        this.moviesSection = moviesSection;
    }

    @Override
    public void performAction() {
        itemController.listAvailableItems(moviesSection);
    }
}