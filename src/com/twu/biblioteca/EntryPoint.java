package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        View view = new View(new Scanner(System.in));

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        bookList.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));

        Books books = new Books(bookList);
        BooksController booksController = new BooksController(books, view);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("List Books", new ListBooksAction(booksController)));
        menuItems.add(new MenuItem("Checkout", new CheckoutBookAction(booksController)));
        menuItems.add(new MenuItem("Quit", new QuitAction()));

        Menu menu = new Menu(menuItems);
        MenuController menuController = new MenuController(menu, view);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(view, books, menu, menuController, booksController);
        bibliotecaApp.start();
    }
}