package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.LoginController;

public class LoginAction implements MenuItemAction {
    private LoginController loginController;

    public LoginAction(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void performAction() {
        loginController.login();
    }
}