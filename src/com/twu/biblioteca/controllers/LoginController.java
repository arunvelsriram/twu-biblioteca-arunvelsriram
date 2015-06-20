package com.twu.biblioteca.controllers;

import com.twu.biblioteca.LoginListener;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.models.Users;
import com.twu.biblioteca.views.View;

import static com.twu.biblioteca.constants.Constants.LIBRARY_NUMBER_PROMPT_MESSAGE;
import static com.twu.biblioteca.constants.Constants.PASSWORD_PROMPT_MESSAGE;

public class LoginController {
    private Users users;
    private View view;
    private LoginListener loginListener;

    public LoginController(Users users, View view) {
        this.users = users;
        this.view = view;
    }

    public void login() {
        view.write(LIBRARY_NUMBER_PROMPT_MESSAGE);
        String libraryNumber = view.read();
        view.write(PASSWORD_PROMPT_MESSAGE);
        String password = view.read();
        User user = users.authenticate(libraryNumber, password);
        view.write(user.statusMessage());
        view.write(user.toString());
        loginListener.update(user);
    }

    public void addLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }
}