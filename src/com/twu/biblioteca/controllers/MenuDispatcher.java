package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.User;

public class MenuDispatcher implements Visitor {
    private MenuController anonymousUserMenuController;
    private MenuController memberMenuController;
    private MenuController librarianMenuController;

    public MenuDispatcher(MenuController anonymousUserMenuController, MenuController memberMenuController,
                          MenuController librarianMenuController) {

        this.anonymousUserMenuController = anonymousUserMenuController;
        this.memberMenuController = memberMenuController;
        this.librarianMenuController = librarianMenuController;
    }

    @Override
    public void visit(User guest) {
        anonymousUserMenuController.showMenu();
        anonymousUserMenuController.chooseOption();
    }
}