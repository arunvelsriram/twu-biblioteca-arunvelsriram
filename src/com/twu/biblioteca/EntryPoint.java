package com.twu.biblioteca;

import com.twu.biblioteca.controllers.ItemController;
import com.twu.biblioteca.controllers.LoginController;
import com.twu.biblioteca.controllers.MenuController;
import com.twu.biblioteca.controllers.MenuDispatcher;
import com.twu.biblioteca.menuitemactions.*;
import com.twu.biblioteca.models.*;
import com.twu.biblioteca.views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        View view = new View(new Scanner(System.in), System.console());

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

        List<User> userDetails = new ArrayList<>();
        userDetails.add(new Member("B1012", "password", "Arun", "arunvelsriram@gmail.com", "919629722335"));
        userDetails.add(new Librarian("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676"));
        Users users = new Users(userDetails);

        MenuDispatcher menuDispatcher = new MenuDispatcher();
        LoginController loginController = new LoginController(users, view, menuDispatcher);

        List<MenuItem> guestMenuItems = new ArrayList<>();
        guestMenuItems.add(new MenuItem("List Books", new ListBooksAction(itemController, booksSection)));
        guestMenuItems.add(new MenuItem("List Movies", new ListMoviesAction(itemController, moviesSection)));
        guestMenuItems.add(new MenuItem("Login", new LoginAction(loginController)));
        guestMenuItems.add(new MenuItem("Invalid Option", new InvalidOptionAction(view)));

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

        Menu guestMenu = new Menu(guestMenuItems);
        Menu memberMenu = new Menu(memberMenuItems);
        Menu librarianMenu = new Menu(librarianMenuItems);

        MenuController guestMenuController = new MenuController(guestMenu, view);
        MenuController memberMenuController = new MenuController(memberMenu, view);
        MenuController librarianMenuController = new MenuController(librarianMenu, view);

        menuDispatcher.setControllers(guestMenuController, memberMenuController, librarianMenuController);

        Guest guest = new Guest();

        BibliotecaApp bibliotecaApp = new BibliotecaApp(view, booksSection, menuDispatcher, guest);
        bibliotecaApp.start();
    }
}