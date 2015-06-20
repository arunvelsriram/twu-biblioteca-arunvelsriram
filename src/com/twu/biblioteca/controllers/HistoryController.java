package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.CheckoutHistory;
import com.twu.biblioteca.views.View;

public class HistoryController {
    private CheckoutHistory checkoutHistory;
    private View view;

    public HistoryController(CheckoutHistory checkoutHistory, View view) {
        this.checkoutHistory = checkoutHistory;
        this.view = view;
    }

    public void showHistory() {
        view.write(checkoutHistory.toString());
    }
}