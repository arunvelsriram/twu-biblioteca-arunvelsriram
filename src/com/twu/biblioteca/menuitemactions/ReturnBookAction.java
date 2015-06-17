package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Section;

import static com.twu.biblioteca.constants.Constants.BOOK_RETURN_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.BOOK_RETURN_SUCCESS_MESSAGE;

public class ReturnBookAction implements MenuItemAction {
    private ItemController itemController;
    private Section booksSection;

    public ReturnBookAction(ItemController itemController, Section booksSection) {
        this.itemController = itemController;
        this.booksSection = booksSection;
    }

    @Override
    public void performAction() {
        itemController.returnAnItem(booksSection, BOOK_RETURN_SUCCESS_MESSAGE, BOOK_RETURN_FAILURE_MESSAGE);
    }
}