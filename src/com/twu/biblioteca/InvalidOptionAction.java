package com.twu.biblioteca;

import com.twu.biblioteca.views.MenuView;

public class InvalidOptionAction implements MenuItemAction {
    private MenuView menuView;

    public InvalidOptionAction(MenuView menuView) {
        this.menuView = menuView;
    }

    @Override
    public void performAction() {
        menuView.write("Select a valid option!");
    }
}
