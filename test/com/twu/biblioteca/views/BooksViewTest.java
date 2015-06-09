package com.twu.biblioteca.views;

import com.twu.biblioteca.Books;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BooksViewTest {
    @Mock
    private Books mockBooks;

    private ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() throws Exception {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void shouldBeAbleToPrintWelcomeMessage() throws Exception {
        BooksView booksView = new BooksView(mockBooks);
        when(mockBooks.toString())
                .thenReturn("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                        "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |");
        booksView.write();

        String actualBookList = byteArrayOutputStream.toString();

        assertThat(actualBookList, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n")));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}