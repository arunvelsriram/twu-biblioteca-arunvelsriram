package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {
    @Mock
    private BooksView mockBooksView;

    @Test
    public void shouldBeAbleToDisplayAMenuWithListOfOptions() {
        Menu menu = new Menu(mockBooksView);
        when(mockBooksView.toString())
                .thenReturn("1. List Books Enter your choice...");

        String actualMenu = menu.toString();

        assertThat(actualMenu, is(equalTo("1. List Books\nEnter your choice...")));
    }
}