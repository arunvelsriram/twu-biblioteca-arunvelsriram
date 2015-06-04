package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldBeAbleToDisplayAWelcomeMessageOnAppStart() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.welcomeMessage();

        String actualMessage = outputStream.toString();

        assertThat(actualMessage, is("Welcome to Biblioteca\n"));
    }

    @Test
    public void shouldBeAbleToDisplayAListOfBooks() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayBooks();

        String actualListOfBooks = outputStream.toString();

        assertThat(actualListOfBooks, is(not("\n")));
    }

    @After
    public void clean() {
        System.setOut(null);
    }
}