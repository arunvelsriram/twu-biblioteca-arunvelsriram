package com.twu.biblioteca;

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