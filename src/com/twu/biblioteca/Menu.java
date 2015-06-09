package com.twu.biblioteca;

import com.twu.biblioteca.views.BooksView;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu(BooksView booksView) {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("List Books", new ListBooksAction(booksView)));
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
}
