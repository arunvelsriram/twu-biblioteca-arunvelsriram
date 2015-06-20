package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.controllers.LoginController;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.models.User;

import java.util.List;

import static com.twu.biblioteca.constants.Constants.BOOK_CHECKOUT_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.BOOK_CHECKOUT_SUCCESS_MESSAGE;

public class CheckoutBookAction implements MenuItemAction, LoginListener {
    private ItemController itemController;
    private Section bookSection;
    private User user;

    public CheckoutBookAction(ItemController itemController, Section bookSection, LoginController loginController) {
        this.itemController = itemController;
        this.bookSection = bookSection;
        loginController.addLoginListener(this);
    }

    @Override
    public void performAction() {
        List<Item> items = itemController.searchAvailableItems(bookSection);
        if(items.isEmpty()) {
            itemController.result(BOOK_CHECKOUT_FAILURE_MESSAGE);
        }
        for(Item item : items) {
            itemController.checkoutAnItem(bookSection, item);
            itemController.result(BOOK_CHECKOUT_SUCCESS_MESSAGE);
        }
    }

    @Override
    public void update(User user) {
        this.user = user;
    }
}