package com.twu.biblioteca;

import com.twu.biblioteca.view.View;

public class QuitAction implements MenuItemAction {
    private View view;

    public QuitAction(View view) {
        this.view = view;
    }

    @Override
    public void performAction() {
        view.write("Bye!");
        System.exit(0);
    }
}