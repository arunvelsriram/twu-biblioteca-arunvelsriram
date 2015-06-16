package com.twu.biblioteca.models;

import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem menuItem(int option) {
        option--;
        return invalidOption(option) ? menuItems.get(option) : menuItems.get(menuItems.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < menuItems.size() - 1; i++) {
            MenuItem menuItem = menuItems.get(i);
            sb.append(i + 1).append(". ").append(menuItem).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private boolean invalidOption(int option) {
        return !(option < 0 || option >= menuItems.size());
    }
}