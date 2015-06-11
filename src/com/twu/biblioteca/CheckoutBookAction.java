package com.twu.biblioteca;

public class CheckoutBookAction implements MenuItemAction {
    private BooksController booksController;

    public CheckoutBookAction(BooksController booksController) {
        this.booksController = booksController;
    }

    @Override
    public void performAction() {
        booksController.checkoutBook();
    }
}