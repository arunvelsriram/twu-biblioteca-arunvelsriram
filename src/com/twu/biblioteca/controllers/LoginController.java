package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.models.Users;
import com.twu.biblioteca.views.View;

import java.util.List;

import static com.twu.biblioteca.constants.Constants.LIBRARY_NUMBER_PROMPT_MESSAGE;
import static com.twu.biblioteca.constants.Constants.PASSWORD_PROMPT_MESSAGE;

public class LoginController {
    private Users users;
    private View view;

    public LoginController(Users users, View view) {
        this.users = users;
        this.view = view;
    }

    public void login() {
        view.write(LIBRARY_NUMBER_PROMPT_MESSAGE);
        String libraryNumber = view.read();
        view.write(PASSWORD_PROMPT_MESSAGE);
        String password = view.read();
        List<User> result = users.authenticate(libraryNumber, password);
    }
}