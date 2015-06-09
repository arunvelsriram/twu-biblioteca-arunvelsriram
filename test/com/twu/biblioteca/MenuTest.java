package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    @Test
    public void shouldBeAbleToDisplayAMenuWithListOfOptions() {
        Menu menu = new Menu();

        String actualMenu = menu.toString();

        assertThat(actualMenu, is(equalTo("1. List Books\nEnter your choice...")));
    }
}