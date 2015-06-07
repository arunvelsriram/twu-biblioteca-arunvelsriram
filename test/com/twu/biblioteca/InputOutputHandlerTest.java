package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputOutputHandlerTest {
    private ByteArrayOutputStream byteArrayOutputStream;
    private ByteArrayInputStream byteArrayInputStream;

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
        Menu menu = new Menu(new MenuItemActionListenerImpl());
        inputOutputHandler.listOptions(menu);

        String actualMenu = byteArrayOutputStream.toString();

        assertThat(actualMenu, is(equalTo("1. List Books\nEnter your choice...")));
    }

    @Test
    public void shouldBeAbleToGetAMenuOptionFromTheUser() {
        String inputData = "1";
        byteArrayInputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(byteArrayInputStream);
        InputOutputHandler inputOutputHandler = new InputOutputHandler();

        int actualOption = inputOutputHandler.readMenuOption();

        assertThat(actualOption, is(equalTo(1)));
    }

    @Test
    public void shouldBeAbleToDisplayErrorMessageOnChoosingInvalidOptionFromTheMenu() throws Exception {
        InputOutputHandler inputOutputHandler = new InputOutputHandler();
        Menu menu = new Menu(new MenuItemActionListenerImpl());
        inputOutputHandler.errorMessage();

        String actualErrorMessage = byteArrayOutputStream.toString();

        assertThat(actualErrorMessage, is(equalTo("Select a valid option!\n")));
    }

    @After
    public void tearDown() {
        System.setOut(null);
        System.setIn(System.in);
    }
}