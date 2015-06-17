package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Section;
import com.twu.biblioteca.views.View;

public class ItemController {
    private View view;

    public ItemController(View view) {
        this.view = view;
    }

    public void listAvailableItems(Section section) {
        view.write(section.availableItems());
    }

    public void checkoutAnItem(Section section, String successMessage, String failureMessage) {
        String title = view.read();
        view.write(section.checkoutItem(title, successMessage, failureMessage));
    }

    public void returnAnItem(Section section, String successMessage, String failureMessage) {
        String title = view.read();
        view.write(section.returnItem(title, successMessage, failureMessage));
    }
}