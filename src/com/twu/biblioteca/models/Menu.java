package com.twu.biblioteca.models;

import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem menuItem(int option) {
        option--;
        return !(option < 0 || option >= menuItems.size()) ? menuItems.get(option) : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (MenuItem menuItem : menuItems) {
            sb.append(i++).append(". ").append(menuItem).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}