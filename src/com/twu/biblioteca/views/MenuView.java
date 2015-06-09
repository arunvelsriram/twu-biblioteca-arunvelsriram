package com.twu.biblioteca.views;

import com.twu.biblioteca.Menu;

import java.util.Scanner;

public class MenuView {
    private Menu menu;
    private Scanner scanner;

    public MenuView(Menu menu) {
        this.menu = menu;
    }

    public void write() {
        System.out.print(menu);
    }

    public void write(String message) {
        System.out.println(message);
    }

    public int read() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}