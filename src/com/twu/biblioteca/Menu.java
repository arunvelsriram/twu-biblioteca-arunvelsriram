package com.twu.biblioteca;

import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (MenuItem menuItem : menuItems) {
            sb.append(i).append(". ").append(menuItem).append("\n");
        }
        sb.append("Enter your choice...");
        return sb.toString();
    }

    public MenuItem menuItem(int option) {
        return menuItems.get(--option);
    }
}