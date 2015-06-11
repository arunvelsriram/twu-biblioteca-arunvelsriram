package com.twu.biblioteca;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.view.View;

public class BibliotecaApp {
    private View view;
    private Books books;
    private Menu menu;

    public BibliotecaApp(View view, Books books, Menu menu) {
        this.view = view;
        this.books = books;
        this.menu = menu;
    }
    public void start() {
        view.write("***Welcome to Biblioteca***");

    }
}