package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.controllers.LoginController;
import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.models.User;

import java.util.List;

import static com.twu.biblioteca.constants.Constants.MOVIE_RETURN_FAILURE_MESSAGE;
import static com.twu.biblioteca.constants.Constants.MOVIE_RETURN_SUCCESS_MESSAGE;

public class ReturnMovieAction implements MenuItemAction, LoginListener {
    private ItemController itemController;
    private Section moviesSection;
    private User user;

    public ReturnMovieAction(ItemController itemController, Section moviesSection, LoginController loginController) {
        this.itemController = itemController;
        this.moviesSection = moviesSection;
        loginController.addLoginListener(this);
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

    @Override
    public void update(User user) {
        this.user = user;
    }
}