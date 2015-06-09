package com.twu.biblioteca.views;

import com.twu.biblioteca.Menu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuViewTest {
    @Mock
    private Menu mockMenu;

    private ByteArrayOutputStream byteArrayOutputStream;
    private ByteArrayInputStream byteArrayInputStream;

    @Before
    public void setUp() throws Exception {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void shouldBeAbleToPrintTheListOfMenuOptions() throws Exception {
        MenuView menuView = new MenuView(mockMenu);
        when(mockMenu.toString())
                .thenReturn("1. List Books\nEnter your choice...");
        menuView.display();

        String actualMessage = byteArrayOutputStream.toString();

        assertThat(actualMessage, is(equalTo("1. List Books\nEnter your choice...")));
    }

    @Test
    public void shouldBeAbleToReadAMenuOptionFromTheUser() throws Exception {
        String inputData = "1";
        byteArrayInputStream = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(byteArrayInputStream);

        MenuView menuView = new MenuView(mockMenu);

        int actualOption = menuView.read();

        assertThat(actualOption, is(equalTo(1)));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setIn(System.in);
    }
}