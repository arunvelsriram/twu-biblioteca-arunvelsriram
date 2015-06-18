package com.twu.biblioteca;

import com.twu.biblioteca.controllers.MenuController;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.View;

public class BibliotecaApp {
    private View view;
    private Section section;
    private MenuController anonymousUserMenuController;

    public BibliotecaApp(View view, Section section, MenuController anonymousUserMenuController) {
        this.view = view;
        this.section = section;
        this.anonymousUserMenuController = anonymousUserMenuController;
    }

    public void start() {
        view.write("***Welcome to Biblioteca***");
        do {
            anonymousUserMenuController.showMenu();
        } while(anonymousUserMenuController.chooseOption());
    }
}