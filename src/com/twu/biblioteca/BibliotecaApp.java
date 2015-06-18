package com.twu.biblioteca;

import com.twu.biblioteca.controllers.MenuDispatcher;
import com.twu.biblioteca.models.Guest;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.View;

public class BibliotecaApp {
    private View view;
    private Section section;
    private Section booksSection;
    private MenuDispatcher menuDispatcher;
    private Guest guest;

    public BibliotecaApp(View view, Section booksSection, MenuDispatcher menuDispatcher, Guest guest) {
        this.view = view;
        this.booksSection = booksSection;
        this.menuDispatcher = menuDispatcher;
        this.guest = guest;
    }


    public void start() {
        view.write("***Welcome to Biblioteca***");
        menuDispatcher.visit(guest);
    }
}