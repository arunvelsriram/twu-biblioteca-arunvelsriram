package com.twu.biblioteca.views;

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
        return scanner.nextInt();
    }

    public String read() {
        return scanner.nextLine();
    }
}