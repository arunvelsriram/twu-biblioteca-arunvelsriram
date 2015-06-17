package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Section;

import java.util.List;

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
        List<Item> items = itemController.searchIssuedItems(booksSection);
        for(Item item : items) {
            itemController.returnAnItem(booksSection, item);
            itemController.result(BOOK_RETURN_SUCCESS_MESSAGE);
            return;
        }
        itemController.result(BOOK_RETURN_FAILURE_MESSAGE);
    }
}