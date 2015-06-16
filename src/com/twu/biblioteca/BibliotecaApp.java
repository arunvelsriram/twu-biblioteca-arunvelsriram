package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BooksController;
import com.twu.biblioteca.controllers.MenuController;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.views.View;

public class BibliotecaApp {
    private View view;
    private Section section;
    private Menu menu;
    private MenuController menuController;
    private BooksController booksController;

    public BibliotecaApp(View view, Section section, Menu menu, MenuController menuController, BooksController booksController) {
        this.view = view;
        this.section = section;
        this.menu = menu;
        this.menuController = menuController;
        this.booksController = booksController;
    }

    public void start() {
        view.write("***Welcome to Biblioteca***");
        do {
            menuController.showMenu();
        } while(menuController.chooseOption());
    }
}