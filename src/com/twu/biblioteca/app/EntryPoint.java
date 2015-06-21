package com.twu.biblioteca.app;

import com.twu.biblioteca.controllers.*;
import com.twu.biblioteca.dispatchers.MenuDispatcher;
import com.twu.biblioteca.menuitemactions.*;
import com.twu.biblioteca.models.*;
import com.twu.biblioteca.views.View;

import java.util.*;

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

        LoginController loginController = new LoginController(users, view);


        Map<User, List<Item>> history = new LinkedHashMap<>();
        CheckoutHistory checkoutHistory = new CheckoutHistory(history);

        HistoryController historyController = new HistoryController(checkoutHistory, view);

        CheckoutBookAction bookCheckoutAction = new CheckoutBookAction(itemController, booksSection, loginController, checkoutHistory);
        ReturnBookAction bookReturnAction = new ReturnBookAction(itemController, booksSection, loginController, checkoutHistory);
        CheckoutMovieAction movieCheckoutAction = new CheckoutMovieAction(itemController, moviesSection, loginController, checkoutHistory);
        ReturnMovieAction movieReturnAction = new ReturnMovieAction(itemController, moviesSection, loginController, checkoutHistory);

        List<MenuItem> guestMenuItems = new ArrayList<>();
        guestMenuItems.add(new MenuItem("List Books", new ListBooksAction(itemController, booksSection)));
        guestMenuItems.add(new MenuItem("List Movies", new ListMoviesAction(itemController, moviesSection)));
        guestMenuItems.add(new MenuItem("Login", new LoginAction(loginController)));
        guestMenuItems.add(new MenuItem("Invalid Option", new InvalidOptionAction(view)));

        List<MenuItem> memberMenuItems = new ArrayList<>();
        memberMenuItems.add(new MenuItem("List Books", new ListBooksAction(itemController, booksSection)));
        memberMenuItems.add(new MenuItem("Checkout Book", bookCheckoutAction));
        memberMenuItems.add(new MenuItem("Return Book", bookReturnAction));
        memberMenuItems.add(new MenuItem("List Movies", new ListMoviesAction(itemController, moviesSection)));
        memberMenuItems.add(new MenuItem("Checkout Movie", movieCheckoutAction));
        memberMenuItems.add(new MenuItem("Return Movie", movieReturnAction));
        memberMenuItems.add(new MenuItem("Logout", null));
        memberMenuItems.add(new MenuItem("Invalid Option", new InvalidOptionAction(view)));

        List<MenuItem> librarianMenuItems = new ArrayList<>();
        librarianMenuItems.add(new MenuItem("List Books", new ListBooksAction(itemController, booksSection)));
        librarianMenuItems.add(new MenuItem("Checkout Book", bookCheckoutAction));
        librarianMenuItems.add(new MenuItem("Return Book", bookReturnAction));
        librarianMenuItems.add(new MenuItem("List Movies", new ListMoviesAction(itemController, moviesSection)));
        librarianMenuItems.add(new MenuItem("Checkout Movie", movieCheckoutAction));
        librarianMenuItems.add(new MenuItem("Return Movie", movieReturnAction));
        librarianMenuItems.add(new MenuItem("Checkout History", new CheckoutHistoryAction(historyController)));
        librarianMenuItems.add(new MenuItem("Logout", null));
        librarianMenuItems.add(new MenuItem("Quit", new QuitAction(view)));
        librarianMenuItems.add(new MenuItem("Invalid Option", new InvalidOptionAction(view)));

        Menu guestMenu = new Menu(guestMenuItems);
        Menu memberMenu = new Menu(memberMenuItems);
        Menu librarianMenu = new Menu(librarianMenuItems);

        MenuController guestMenuController = new MenuController(guestMenu, view);
        MenuController memberMenuController = new MenuController(memberMenu, view);
        MenuController librarianMenuController = new MenuController(librarianMenu, view);

        MenuDispatcher menuDispatcher = new MenuDispatcher(guestMenuController, memberMenuController, librarianMenuController);

        User guest = new Guest();

        BibliotecaApp bibliotecaApp = new BibliotecaApp(view, menuDispatcher, guest, loginController);
        bibliotecaApp.start();
    }
}