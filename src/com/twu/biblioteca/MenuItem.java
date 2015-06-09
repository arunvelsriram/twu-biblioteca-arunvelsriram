package com.twu.biblioteca;

public class MenuItem {
    private String name;
    private MenuItemAction menuItemAction;

    public MenuItem(String name, MenuItemAction menuItemAction) {
        this.name = name;
        this.menuItemAction = menuItemAction;
    }

    public void performAction() {
        menuItemAction.performAction();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        return sb.toString();
    }
}