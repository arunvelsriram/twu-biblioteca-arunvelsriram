package com.twu.biblioteca.menuitemactions;

import com.twu.biblioteca.controllers.HistoryController;

public class CheckoutHistoryAction implements MenuItemAction {
    private HistoryController historyController;

    public CheckoutHistoryAction(HistoryController historyController) {
        this.historyController = historyController;
    }

    @Override
    public void performAction() {
        historyController.showHistory();
    }
}