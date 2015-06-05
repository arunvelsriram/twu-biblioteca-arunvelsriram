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

        assertThat(actualMessage, is(equalTo("Welcome to Biblioteca\n")));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}