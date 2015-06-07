package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class OutputHandlerTest {
    private ByteArrayOutputStream byteArrayOutputStream;
    private OutputHandler outputHandler;

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        outputHandler = new OutputHandler();
    }

    @Test
    public void shouldBeAbleToDisplayWelcomeMessage() {
        outputHandler.welcomeMessage();

        String actualMessage = byteArrayOutputStream.toString();

        assertThat(actualMessage, is(equalTo("***Welcome to Biblioteca***\n")));
    }

    @Test
    public void shouldBeAbleToDisplayBookDetails() {
        Books books = new Books();
        outputHandler.bookDetails(books);

        String actualBookDetails = byteArrayOutputStream.toString();

        assertThat(actualBookDetails, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n")));
    }

    @Test
    public void shouldBeAbleToDisplayAMenuWithListOfOptions() {
        Menu menu = new Menu();
        outputHandler.listOptions(menu);

        assertThat(byteArrayOutputStream.toString(), is(equalTo("\n")));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}