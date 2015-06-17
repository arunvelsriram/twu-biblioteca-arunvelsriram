package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Section;

public class ListBooksAction implements MenuItemAction {
    private ItemController itemController;
    private Section booksSection;

    public ListBooksAction(ItemController itemController, Section booksSection) {
        this.itemController = itemController;
        this.booksSection = booksSection;
    }

    @Override
    public void performAction() {
        itemController.listAvailableItems(booksSection);
    }
}