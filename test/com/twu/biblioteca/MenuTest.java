package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {
    @Mock
    private MenuItemAction mockMenuItemAction;

    @Test
    public void shouldBeAbleToDisplayAMenuWithListOfOptions() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("List Books", mockMenuItemAction));
        Menu menu = new Menu(menuItems);

        String actualMenu = menu.toString();

        assertThat(actualMenu, is(equalTo("1. List Books\nEnter your choice...")));
    }

    @Test
    public void shouldBeAbleReturnAMenuItemBasedOnUsersOption() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("List Books", mockMenuItemAction));
        Menu menu = new Menu(menuItems);

        MenuItem actualMenuItem = menu.menuItem(1);

        assertThat(actualMenuItem, is(equalTo(menuItems.get(0))));
    }

}