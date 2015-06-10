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
    private Books books;
    private Menu menu;

    public BibliotecaApp(BibliotecaAppView bibliotecaAppView, BooksView booksView, MenuView menuView, Books books, Menu menu) {
        this.bibliotecaAppView = bibliotecaAppView;
        this.booksView = booksView;
        this.menuView = menuView;
        this.books = books;
        this.menu = menu;
    }

    public void start() {
        bibliotecaAppView.write("***Welcome to Biblioteca***");
        menuView.write();
        int option = menuView.read();
        MenuItem menuItem = menu.menuItem(option);
        if(menuItem != null) {
            menuItem.performAction();
        } else {
            menuView.write("Select a valid option!");
        }
    }

    public static void main(String[] args) {
        BibliotecaAppView bibliotecaAppView  = new BibliotecaAppView();

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        bookList.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));

        Books books = new Books(bookList);
        BooksView booksView = new BooksView(books);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("List Books", new ListBooksAction(booksView)));
        menuItems.add(new MenuItem("Quit", new QuitAction(bibliotecaAppView)));

        Menu menu = new Menu(menuItems);
        MenuView menuView = new MenuView(menu);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaAppView, booksView, menuView, books, menu);
        bibliotecaApp.start();
    }
}