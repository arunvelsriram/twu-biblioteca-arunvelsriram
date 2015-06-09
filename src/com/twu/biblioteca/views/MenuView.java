package com.twu.biblioteca.views;

import com.twu.biblioteca.Menu;

import java.util.Scanner;

public class MenuView {
    private Menu menu;
    private Scanner scanner;

    public MenuView(Menu menu) {
        this.menu = menu;
    }

    public void display() {
        System.out.print(menu);
    }

    public int read() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}