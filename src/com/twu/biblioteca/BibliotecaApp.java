package com.twu.biblioteca;

import com.twu.biblioteca.controllers.LoginController;
import com.twu.biblioteca.controllers.MenuDispatcher;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.View;

public class BibliotecaApp implements LoginListener {
    private View view;
    private MenuDispatcher menuDispatcher;
    private User user;
    private LoginController loginController;

    public BibliotecaApp(View view, MenuDispatcher menuDispatcher, User guest, LoginController loginController) {
        this.view = view;
        this.menuDispatcher = menuDispatcher;
        this.user = guest;
        this.loginController = loginController;
        this.loginController.addLoginListener(this);
    }


    public void start() {
        view.write("***Welcome to Biblioteca***");
        user.accept(menuDispatcher);
    }

    @Override
    public void update(User user) {
        this.user = user;
        this.user.accept(menuDispatcher);
    }
}