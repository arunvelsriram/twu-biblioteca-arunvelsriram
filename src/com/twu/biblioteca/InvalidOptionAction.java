package com.twu.biblioteca;

import com.twu.biblioteca.views.View;

public class InvalidOptionAction implements MenuItemAction {

    private View view;

    public InvalidOptionAction(View view) {
        this.view = view;
    }

    @Override
    public void performAction() {
        view.write("Select a valid option!");
    }
}