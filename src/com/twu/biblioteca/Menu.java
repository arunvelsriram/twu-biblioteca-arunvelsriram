package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, String> menuItems;
    private MenuItemActionListener menuItemActionListener;

    public Menu(MenuItemActionListener menuItemActionListener) {
        this.menuItemActionListener = menuItemActionListener;
        menuItems = new HashMap<>();
        menuItems.put(1, "List Books");
    }

    public void choose(int option) {
        String menuItem = menuItems.get(option);
        menuItemActionListener.actionPerformed(option);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= menuItems.size(); i++) {
            sb.append(i).append(". ").append(menuItems.get(i)).append("\n");
        }
        sb.append("Enter your choice...");
        return sb.toString();
    }
}
