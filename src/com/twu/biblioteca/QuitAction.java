package com.twu.biblioteca;

import com.twu.biblioteca.views.BibliotecaAppView;

public class QuitAction implements MenuItemAction {
    private BibliotecaAppView bibliotecaAppView;

    public QuitAction(BibliotecaAppView bibliotecaAppView) {
        this.bibliotecaAppView = bibliotecaAppView;
    }

    @Override
    public void performAction() {
        bibliotecaAppView.write("Bye!");
        System.exit(0);
    }
}