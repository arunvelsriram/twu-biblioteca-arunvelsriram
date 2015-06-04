package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {
    @Test
    public void shouldDisplayAWelcomeMessageOnceTheAppIsLaunched() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Library());

        String actual = bibliotecaApp.welcomeMessage();

        assertThat(actual, instanceOf(String.class));
    }
}