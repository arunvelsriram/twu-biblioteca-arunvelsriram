package com.twu.biblioteca;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.controllers.MenuController;
import com.twu.biblioteca.menuitemactions.*;
import com.twu.biblioteca.models.*;
import com.twu.biblioteca.views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        View view = new View(new Scanner(System.in));

        List<Item> availableBooks = new ArrayList<>();
        availableBooks.add(new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999));
        availableBooks.add(new Book("Harry Potter and The Chamber of Secrets", "JK Rowling", 2000));
        List<Item> issuedBooks = new ArrayList<>();
        Section booksSection = new Section(availableBooks, issuedBooks);

        List<Item> availableMovies = new ArrayList<>();
        availableMovies.add(new Movie("Inception", "Christopher Nolan", 2010, "10"));
        availableMovies.add(new Movie("The Prestige", "Christopher Nolan", 2008, "10"));
        List<Item> issuedMovies = new ArrayList<>();
        Section moviesSection = new Section(availableMovies, issuedMovies);

        ItemController itemController = new ItemController(view);

        List<MenuItem> anonymousUserMenuItems = new ArrayList<>();
        anonymousUserMenuItems.add(new MenuItem("List Books", new ListBooksAction(itemController, booksSection)));
        anonymousUserMenuItems.add(new MenuItem("List Movies", new ListMoviesAction(itemController, moviesSection)));
        anonymousUserMenuItems.add(new MenuItem("Login", null));
        anonymousUserMenuItems.add(new MenuItem("Invalid Option", new InvalidOptionAction(view)));

        List<MenuItem> memberMenuItems = new ArrayList<>();
        memberMenuItems.add(new MenuItem("List Books", new ListBooksAction(itemController, booksSection)));
        memberMenuItems.add(new MenuItem("Checkout Book", new CheckoutBookAction(itemController, booksSection)));
        memberMenuItems.add(new MenuItem("Return Book", new ReturnBookAction(itemController, booksSection)));
        memberMenuItems.add(new MenuItem("List Movies", new ListMoviesAction(itemController, moviesSection)));
        memberMenuItems.add(new MenuItem("Checkout Movie", new CheckoutMovieAction(itemController, moviesSection)));
        memberMenuItems.add(new MenuItem("Return Movie", new ReturnMovieAction(itemController, moviesSection)));
        memberMenuItems.add(new MenuItem("Logout", null));
        memberMenuItems.add(new MenuItem("Invalid Option", new InvalidOptionAction(view)));

        List<MenuItem> librarianMenuItems = new ArrayList<>();
        librarianMenuItems.add(new MenuItem("List Books", new ListBooksAction(itemController, booksSection)));
        librarianMenuItems.add(new MenuItem("Checkout Book", new CheckoutBookAction(itemController, booksSection)));
        librarianMenuItems.add(new MenuItem("Return Book", new ReturnBookAction(itemController, booksSection)));
        librarianMenuItems.add(new MenuItem("List Movies", new ListMoviesAction(itemController, moviesSection)));
        librarianMenuItems.add(new MenuItem("Checkout Movie", new CheckoutMovieAction(itemController, moviesSection)));
        librarianMenuItems.add(new MenuItem("Return Movie", new ReturnMovieAction(itemController, moviesSection)));
        librarianMenuItems.add(new MenuItem("Checkout History", null));
        librarianMenuItems.add(new MenuItem("Logout", null));
        librarianMenuItems.add(new MenuItem("Quit", null));
        librarianMenuItems.add(new MenuItem("Invalid Option", new InvalidOptionAction(view)));

        Menu anonymousUserMenu = new Menu(anonymousUserMenuItems);
        Menu memberMenu = new Menu(memberMenuItems);
        Menu librarianMenu = new Menu(librarianMenuItems);

        MenuController anonymousUserMenuController = new MenuController(anonymousUserMenu, view);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(view, booksSection, anonymousUserMenuController);
        bibliotecaApp.start();
    }
}