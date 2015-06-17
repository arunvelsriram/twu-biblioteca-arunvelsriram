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

    public void checkoutItem(Item item) {
        availableItems.remove(item);
        issuedItems.add(item);
    }

    public void returnItem(Item item) {
        issuedItems.remove(item);
        availableItems.add(item);
    }

    public List<Item> searchAvailableItems(String title) {
        return search(title, availableItems);
    }

    public List<Item> searchIssuedItems(String title) {
        return search(title, issuedItems);
    }

    public String availableItems() {
        return items(availableItems);
    }

    public String issuedItems() {
        return items(issuedItems);
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

    private String items(List<Item> list) {
        StringBuilder sb = new StringBuilder();
        for (Item item : list) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}