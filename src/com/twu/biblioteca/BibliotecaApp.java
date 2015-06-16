package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BooksController;
import com.twu.biblioteca.controllers.MenuController;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.views.View;

public class BibliotecaApp {
    private View view;
    private Library library;
    private Menu menu;
    private MenuController menuController;
    private BooksController booksController;

    public BibliotecaApp(View view, Library library, Menu menu, MenuController menuController, BooksController booksController) {
        this.view = view;
        this.library = library;
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