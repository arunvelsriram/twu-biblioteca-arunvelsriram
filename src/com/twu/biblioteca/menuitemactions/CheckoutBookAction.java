package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.models.Section;

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
        itemController.checkoutAnItem(bookSection, BOOK_CHECKOUT_SUCCESS_MESSAGE, BOOK_CHECKOUT_FAILURE_MESSAGE);
    }
}