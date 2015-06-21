package com.twu.biblioteca.views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View(Scanner scanner) {
        this.scanner = scanner;
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
}