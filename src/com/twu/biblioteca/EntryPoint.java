package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BooksController;
import com.twu.biblioteca.controllers.MenuController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.views.View;

import java.util.*;

public class EntryPoint {
    public static void main(String[] args) {
        View view = new View(new Scanner(System.in));

        Map<Book, Boolean> availableBooks = new LinkedHashMap<>();
        availableBooks.put(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999), true);
        availableBooks.put(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000), true);

        Books books = new Books(availableBooks);
        BooksController booksController = new BooksController(books, view);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("List Books", new ListBooksAction(booksController)));
        menuItems.add(new MenuItem("Checkout Book", new CheckoutBookAction(booksController)));
        menuItems.add(new MenuItem("Return Book", new ReturnBookAction(booksController)));
        menuItems.add(new MenuItem("Quit", null));

        Menu menu = new Menu(menuItems);
        MenuController menuController = new MenuController(menu, view);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(view, books, menu, menuController, booksController);
        bibliotecaApp.start();
    }
}