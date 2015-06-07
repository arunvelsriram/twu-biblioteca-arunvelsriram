package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class InputOutputHandlerTest {
    private ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void shouldBeAbleToDisplayWelcomeMessage() {
        InputOutputHandler inputOutputHandler = new InputOutputHandler();
        inputOutputHandler.welcomeMessage();

        String actualMessage = byteArrayOutputStream.toString();

        assertThat(actualMessage, is(equalTo("***Welcome to Biblioteca***\n")));
    }

    @Test
    public void shouldBeAbleToDisplayBookDetails() {
        InputOutputHandler inputOutputHandler = new InputOutputHandler();
        inputOutputHandler.bookDetails(new Books());

        String actualBookDetails = byteArrayOutputStream.toString();

        assertThat(actualBookDetails, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |\n" +
                "| Harry Potter and The Chamber of Secrets | JK Rowling | 2000 |\n")));
    }

    @Test
    public void shouldBeAbleToDisplayAMenuWithListOfOptions() {
        InputOutputHandler inputOutputHandler = new InputOutputHandler();
        inputOutputHandler.listOptions(new Menu());

        assertThat(byteArrayOutputStream.toString(), is(equalTo("1. List Books\nEnter your choice...")));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}