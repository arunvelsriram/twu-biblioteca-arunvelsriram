package com.twu.biblioteca;

public class MenuItem {
    private String name;
    private MenuItemActionListener menuItemActionListener;

    public MenuItem(String name, MenuItemActionListener menuItemActionListener) {
        this.name = name;
        this.menuItemActionListener = menuItemActionListener;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        return sb.toString();
    }
}