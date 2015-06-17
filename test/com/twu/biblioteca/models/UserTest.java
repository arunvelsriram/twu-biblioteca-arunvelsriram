package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User("B1011", "password".toCharArray(), "Arun", "arunvelsriram@gmail.com", "919629722335");
    }

    @Test
    public void shouldBeAbleToIdentifyAValidUser() {
        boolean actual = user.valid("B1011", "password".toCharArray());

        assertTrue(actual);
    }

    @Test
    public void shouldBeAbleToCheckTheUserName() {
        boolean actual = user.valid("B1111", "password".toCharArray());

        assertFalse(actual);
    }

    @Test
    public void shouldBeAbleToCheckThePassword() {
        boolean actual = user.valid("B1011", "pasword".toCharArray());

        assertFalse(actual);
    }

    @Test
    public void shouldBeAbleToCheckBothUserNameAndPassword() {
        boolean actual = user.valid("B1111", "pasword".toCharArray());

        assertFalse(actual);
    }
}