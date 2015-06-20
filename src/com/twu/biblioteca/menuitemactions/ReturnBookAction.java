package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.controllers.LoginController;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.models.User;

import java.util.List;

import static com.twu.biblioteca.constants.Constants.BOOK_RETURN_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.BOOK_RETURN_SUCCESS_MESSAGE;

public class ReturnBookAction implements MenuItemAction, LoginListener {
    private ItemController itemController;
    private Section booksSection;
    private User user;

    public ReturnBookAction(ItemController itemController, Section booksSection, LoginController loginController) {
        this.itemController = itemController;
        this.booksSection = booksSection;
        loginController.addLoginListener(this);
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

    @Override
    public void update(User user) {
        this.user = user;
    }
}