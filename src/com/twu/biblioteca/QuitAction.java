package com.twu.biblioteca;

public class QuitAction implements MenuItemAction {
    @Override
    public void performAction() {
        System.exit(0);
    }
}