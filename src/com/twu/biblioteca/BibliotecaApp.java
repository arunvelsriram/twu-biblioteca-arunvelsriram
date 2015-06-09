package com.twu.biblioteca;

import com.twu.biblioteca.views.BibliotecaAppView;

public class BibliotecaApp {
    private BibliotecaAppView bibliotecaAppView;

    public BibliotecaApp(BibliotecaAppView bibliotecaAppView) {
        this.bibliotecaAppView = bibliotecaAppView;
    }

    public void start() {
        bibliotecaAppView.display("***Welcome to Biblioteca***");
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new BibliotecaAppView());
        bibliotecaApp.start();
    }
}