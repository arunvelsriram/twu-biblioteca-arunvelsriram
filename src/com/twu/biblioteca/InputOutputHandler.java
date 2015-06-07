package com.twu.biblioteca;

import java.util.Scanner;

public class InputOutputHandler {
    private Scanner scanner;

    public InputOutputHandler() {
        scanner = new Scanner(System.in);
    }

    public void welcomeMessage() {
        System.out.println("***Welcome to Biblioteca***");
    }

    public void bookDetails(Books books) {
        System.out.println(books);
    }

    public void listOptions(Menu menu) {
        System.out.print(menu);
    }

    public int readMenuOption() {
        return scanner.nextInt();
    }

    public void errorMessage() {
        System.out.println("Select a valid option!");
    }
}