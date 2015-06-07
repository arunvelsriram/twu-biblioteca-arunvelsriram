package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, String> menuItems;
    private Map<String, MenuItemActionListener> menuItemActionMap;

    public Menu() {
        menuItems = new HashMap<>();
        menuItemActionMap = new HashMap<>();
        menuItems.put(1, "List Books");
        menuItemActionMap.put("List Books", new MenuItemActionListener() {
            @Override
            public void actionPerformed(OutputHandler outputHandler) {
                Books books = new Books();
                outputHandler.bookDetails(books);
            }
        });
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
