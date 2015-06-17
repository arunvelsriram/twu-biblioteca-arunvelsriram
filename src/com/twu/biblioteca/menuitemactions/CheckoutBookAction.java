package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Section;

import java.util.List;

import static com.twu.biblioteca.constants.Constants.BOOK_CHECKOUT_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.BOOK_CHECKOUT_SUCCESS_MESSAGE;

public class CheckoutBookAction implements MenuItemAction {
    private ItemController itemController;
    private Section bookSection;

    public CheckoutBookAction(ItemController itemController, Section bookSection) {
        this.itemController = itemController;
        this.bookSection = bookSection;
    }

    @Override
    public void performAction() {
        List<Item> items = itemController.searchAvailableItems(bookSection);
        for(Item item : items) {
            itemController.checkoutAnItem(bookSection, item);
            itemController.result(BOOK_CHECKOUT_SUCCESS_MESSAGE);
            return;
        }
        itemController.result(BOOK_CHECKOUT_FAILURE_MESSAGE);
    }
}