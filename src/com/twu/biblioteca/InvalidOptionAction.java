package com.twu.biblioteca;

import com.twu.biblioteca.controllers.MenuController;

public class InvalidOptionAction implements MenuItemAction {
    private MenuController menuController;

    public InvalidOptionAction(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public void performAction() {
        menuController.invalidOption();
    }
}