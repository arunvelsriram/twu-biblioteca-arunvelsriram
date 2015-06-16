package com.twu.biblioteca.models;

import com.twu.biblioteca.menuitemactions.InvalidOptionAction;
import com.twu.biblioteca.menuitemactions.MenuItemAction;
import org.junit.Before;
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
    private MenuItemAction menuItemActionStub;
    @Mock
    private InvalidOptionAction invalidOptionActionStub;
    private List<MenuItem> menuItems;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("List Books", menuItemActionStub));
        menuItems.add(new MenuItem("Checkout Book", menuItemActionStub));
        menuItems.add(new MenuItem("Return Book", menuItemActionStub));
        menuItems.add(new MenuItem("Quit", null));
        menuItems.add(new MenuItem("Invalid Option", menuItemActionStub));
        menu = new Menu(menuItems);
    }

    @Test
    public void shouldBeAbleToDisplayAMenuWithListOfOptions() {
        String actualMenu = menu.toString();

        assertThat(actualMenu, is(equalTo("1. List Books\n2. Checkout Book\n3. Return Book\n4. Quit")));
    }

    @Test
    public void shouldBeAbleReturnAMenuItemBasedOnUsersOption() {
        MenuItem actualMenuItem = menu.menuItem(1);

        assertThat(actualMenuItem, is(equalTo(menuItems.get(0))));
    }

    @Test
    public void shouldReturnInvalidOptionMenuItemOnProvidingAnInvalidOption() throws Exception {
        MenuItem actualMenuItem = menu.menuItem(10);

        assertThat(actualMenuItem, is(equalTo(menuItems.get(4))));
    }
}