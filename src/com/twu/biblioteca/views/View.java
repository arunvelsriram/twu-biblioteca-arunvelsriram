package com.twu.biblioteca.views;

import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    private Scanner scanner;
    private Console console;

    public View(Scanner scanner, Console console) {
        this.scanner = scanner;
        this.console = console;
    }

    public void write(String message) {
        System.out.println(message);
    }

    public int readInt() {
        int option = 0;
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException exception) {
            option = 0;
        } finally {
            scanner.nextLine();
        }
        return option;
    }

    public String read() {
        return scanner.nextLine();
    }

    public char[] readPassword() {
        return console.readPassword();
    }
}