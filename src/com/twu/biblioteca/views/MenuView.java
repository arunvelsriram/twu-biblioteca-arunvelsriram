package com.twu.biblioteca.views;

import com.twu.biblioteca.Menu;

public class MenuView {
    private Menu menu;

    public MenuView(Menu menu) {
        this.menu = menu;
    }

    public void show() {
        System.out.print(menu);
    }
}