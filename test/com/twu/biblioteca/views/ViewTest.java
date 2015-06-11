package com.twu.biblioteca.views;

import com.twu.biblioteca.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ViewTest {
    private ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() throws Exception {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void shouldBeAbleToPrintWelcomeMessage() throws Exception {
        View view = new View(new Scanner(System.in));
        view.write("***Welcome to Biblioteca***");

        String actualMessage = byteArrayOutputStream.toString();

        assertThat(actualMessage, is(equalTo("***Welcome to Biblioteca***\n")));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}