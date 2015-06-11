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

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("List Books", new ListBooksAction(view, books)));
        menuItems.add(new MenuItem("Quit", new QuitAction(view)));

        Menu menu = new Menu(menuItems);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(view, books, menu);
        bibliotecaApp.start();
    }
}