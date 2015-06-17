package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Item;
import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.View;

import java.util.List;

public class ItemController {
    private View view;

    public ItemController(View view) {
        this.view = view;
    }

    public void listAvailableItems(Section section) {
        String availableItems = section.availableItems();
        view.write(availableItems);
    }

    public List<Item> searchAvailableItems(Section section) {
        String name = view.read();
        return section.searchAvailableItems(name);
    }

    public List<Item> searchIssuedItems(Section section) {
        String name = view.read();
        return section.searchIssuedItems(name);
    }

    public void checkoutAnItem(Section section, Item item) {
        section.checkoutItem(item);
    }

    public void returnAnItem(Section section, Item item) {
        section.returnItem(item);
    }

    public void result(String message) {
        view.write(message);
    }
}