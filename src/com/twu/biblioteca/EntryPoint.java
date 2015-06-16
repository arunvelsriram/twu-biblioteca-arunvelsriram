package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BooksController;
import com.twu.biblioteca.controllers.MenuController;
import com.twu.biblioteca.menuitemactions.CheckoutBookAction;
import com.twu.biblioteca.menuitemactions.InvalidOptionAction;
import com.twu.biblioteca.menuitemactions.ListBooksAction;
import com.twu.biblioteca.menuitemactions.ReturnBookAction;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.views.View;

import java.util.*;

public class EntryPoint {
    public static void main(String[] args) {
        View view = new View(new Scanner(System.in));

        List<Book> availableBooks = new ArrayList<>();
        availableBooks.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        availableBooks.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));
        List<Book> issuedBooks = new ArrayList<>();

        Library library = new Library(availableBooks, issuedBooks);
        BooksController booksController = new BooksController(library, view);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("List Books", new ListBooksAction(booksController)));
        menuItems.add(new MenuItem("Checkout Book", new CheckoutBookAction(booksController)));
        menuItems.add(new MenuItem("Return Book", new ReturnBookAction(booksController)));
        menuItems.add(new MenuItem("Quit", null));
        menuItems.add(new MenuItem("Invalid Option", new InvalidOptionAction(view)));

        Menu menu = new Menu(menuItems);
        MenuController menuController = new MenuController(menu, view);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(view, library, menu, menuController, booksController);
        bibliotecaApp.start();
    }
}