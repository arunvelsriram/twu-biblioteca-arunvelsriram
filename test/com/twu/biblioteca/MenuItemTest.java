package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuItemTest {

    @Test
    public void shouldBeAbleToReturnAMenuItem() throws Exception {
        MenuItem menuItem = new MenuItem("List Books", new ListBooksAction());

        String actualMenuItem = menuItem.toString();

        assertThat(actualMenuItem, is(equalTo("List Books")));
    }
}