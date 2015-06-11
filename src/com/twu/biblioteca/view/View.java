package com.twu.biblioteca.view;

import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View(Scanner scanner) {
        this.scanner = scanner;
    }

    public void write(String message) {
        System.out.println(message);
    }

    public int read() {
        return scanner.nextInt();
    }
}