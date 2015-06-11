package com.twu.biblioteca;

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