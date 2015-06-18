package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.User;

public class MenuDispatcher implements Visitor {
    private MenuController guestMenuController;
    private MenuController memberMenuController;
    private MenuController librarianMenuController;

    public MenuDispatcher(MenuController guestMenuController, MenuController memberMenuController,
                          MenuController librarianMenuController) {

        this.guestMenuController = guestMenuController;
        this.memberMenuController = memberMenuController;
        this.librarianMenuController = librarianMenuController;
    }

    @Override
    public void visit(User guest) {
        do {
            guestMenuController.showMenu();
        } while(guestMenuController.chooseOption());
    }
}