package com.twu.biblioteca;

import com.twu.biblioteca.views.BibliotecaAppView;
import com.twu.biblioteca.views.BooksView;
import com.twu.biblioteca.views.MenuView;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private BibliotecaAppView bibliotecaAppView;
    private BooksView booksView;
    private MenuView menuView;

    public BibliotecaApp(BibliotecaAppView bibliotecaAppView, BooksView booksView, MenuView menuView) {
        this.bibliotecaAppView = bibliotecaAppView;
        this.booksView = booksView;
        this.menuView = menuView;
    }

    public void start() {
        bibliotecaAppView.display("***Welcome to Biblioteca***");
        menuView.display();
    }

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        bookList.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));

        Books books = new Books(bookList);
        BooksView booksView = new BooksView(books);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("List Books", new ListBooksAction(booksView)));

        Menu menu = new Menu(menuItems);
        MenuView menuView = new MenuView(menu);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(new BibliotecaAppView(), booksView, menuView);
        bibliotecaApp.start();
    }
}