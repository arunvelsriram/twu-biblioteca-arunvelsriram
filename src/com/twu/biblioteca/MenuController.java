package com.twu.biblioteca;

import com.twu.biblioteca.models.Menu;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.views.View;

public class MenuController {
    private Menu menu;
    private View view;

    public MenuController(Menu menu, View view) {
        this.menu = menu;
        this.view = view;
    }

    public void showMenu() {
       view.write(menu.toString());
    }

    public void select() {
        int option = view.read();
        MenuItem menuItem =  menu.menuItem(option);
        menuItem.performAction();
    }
}