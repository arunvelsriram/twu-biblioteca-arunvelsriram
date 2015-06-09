package com.twu.biblioteca;

public class MenuView {
    private Menu menu;

    public MenuView(Menu menu) {
        this.menu = menu;
    }

    public void show() {
        System.out.print(menu);
    }
}