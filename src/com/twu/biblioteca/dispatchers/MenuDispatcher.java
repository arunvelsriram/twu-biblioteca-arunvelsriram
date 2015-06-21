package com.twu.biblioteca.dispatchers;

import com.twu.biblioteca.controllers.MenuController;
import com.twu.biblioteca.dispatchers.Dispatcher;
import com.twu.biblioteca.models.Guest;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.Member;

public class MenuDispatcher implements Dispatcher {
    private MenuController guestMenuController;
    private MenuController memberMenuController;
    private MenuController librarianMenuController;

    public MenuDispatcher(MenuController guestMenuController,
                          MenuController memberMenuController, MenuController librarianMenuController) {
        this.guestMenuController = guestMenuController;
        this.memberMenuController = memberMenuController;
        this.librarianMenuController = librarianMenuController;
    }

    @Override
    public void dispatch(Guest guest) {
        do {
            guestMenuController.showMenu();
        } while(guestMenuController.chooseOption());
    }

    @Override
    public void dispatch(Librarian librarian) {
        do {
            librarianMenuController.showMenu();
        } while(librarianMenuController.chooseOption());
    }

    @Override
    public void dispatch(Member member) {
        do {
            memberMenuController.showMenu();
        } while(memberMenuController.chooseOption());
    }
}