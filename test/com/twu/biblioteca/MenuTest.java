package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    @Test
    public void shouldBeAbleToReturnAvailableOptions() {
        Menu menu = new Menu();

        String actualOptions = menu.toString();

        assertThat(actualOptions, is(equalTo("1. List Books\nEnter your choice...")));
    }
}