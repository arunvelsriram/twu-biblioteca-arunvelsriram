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
public class MenuItemTest {
    @Mock
    private BooksView mockBookView;

    @Test
    public void shouldBeAbleToReturnAMenuItem() throws Exception {
        MenuItem menuItem = new MenuItem("List Books", new ListBooksAction(mockBookView));
        when(mockBookView.toString()).thenReturn("List Books");

        String actualMenuItem = menuItem.toString();

        assertThat(actualMenuItem, is(equalTo("List Books")));
    }
}