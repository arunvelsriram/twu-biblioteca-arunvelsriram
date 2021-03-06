package com.twu.biblioteca.views;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ViewTest {
    private ByteArrayOutputStream byteArrayOutputStream;
    private ByteArrayInputStream byteArrayInputStream;

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }
    
    @Test
    public void shouldBeAbleToPrintWelcomeMessage() {
        View view = new View(new Scanner(System.in));
        view.write("***Welcome to Biblioteca***");

        String actualMessage = byteArrayOutputStream.toString();

        assertThat(actualMessage, is(equalTo("***Welcome to Biblioteca***\n")));
    }

    @Test
    public void shouldBeAbleToReadAMenuOptionFromTheUserAndReturnIt() {
        String inputData = "1 ";
        byteArrayInputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(byteArrayInputStream);
        View view = new View(new Scanner(System.in));

        int actualOption = view.readInt();

        assertThat(actualOption, is(equalTo(1)));
    }

    @Test
    public void shouldBeAbleToReturnZeroOnReadingInvalidMenuOptionFromTheUser() {
        String inputData = "hello";
        byteArrayInputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(byteArrayInputStream);
        View view = new View(new Scanner(System.in));

        int actualOption = view.readInt();

        assertThat(actualOption, is(equalTo(0)));
    }

    @Test
    public void shouldBeAbleToReadBookNameFromThConsole() {
        String inputData = "Harry Potter and The Sorcer's Stone";
        byteArrayInputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(byteArrayInputStream);
        View view = new View(new Scanner(System.in));

        String actualBookName = view.read();

        assertThat(actualBookName, is(equalTo("Harry Potter and The Sorcer's Stone")));
    }

    @After
    public void tearDown() {
        System.setOut(null);
        System.setIn(System.in);
    }
}