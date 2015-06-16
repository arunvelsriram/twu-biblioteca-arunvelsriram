package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private List<Item> availableItems;
    private List<Item> issuedItems;

    public Section(List<Item> availableItems, List<Item> issuedItems) {
        this.availableItems = availableItems;
        this.issuedItems = issuedItems;
    }

    public String availableItems() {
        StringBuilder sb = new StringBuilder();
        for (Item item : availableItems) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }

    public boolean checkoutItem(String title) {
        List<Item> result = search(title, availableItems);
        for (Item item : result) {
            availableItems.remove(item);
            issuedItems.add(item);
            return true;
        }
        return false;
    }

    public boolean returnItem(String title) {
        List<Item> result = search(title, issuedItems);
        for (Item item : result) {
            issuedItems.remove(item);
            availableItems.add(item);
            return true;
        }
        return false;
    }

    private List<Item> search(String title, List<Item> books) {
        List<Item> result = new ArrayList<>();
        for (Item item : books) {
            if (item.match(title)) {
                result.add(item);
            }
        }
        return result;
    }
}