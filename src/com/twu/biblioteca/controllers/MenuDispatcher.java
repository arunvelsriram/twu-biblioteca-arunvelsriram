package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Guest;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.Member;

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
    public void visit(Guest guest) {
        do {
            guestMenuController.showMenu();
        } while(guestMenuController.chooseOption());
    }

    @Override
    public void visit(Librarian librarian) {

    }

    @Override
    public void visit(Member member) {
    }
}