package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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

    @Test
    public void equalityShouldSatisfyReflexivity() {
        User user = new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676");

        assertThat(user, is(equalTo(user)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        User user = new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676");
        User userTwo = new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676");

        assertThat(user, is(equalTo(userTwo)));
        assertThat(userTwo, is(equalTo(user)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        User user = new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676");
        User userTwo = new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676");
        User userThree = new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676");

        assertThat(user, is(equalTo(userTwo)));
        assertThat(userTwo, is(equalTo(userThree)));
        assertThat(user, is(equalTo(userThree)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        User user = new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676");

        assertFalse(user.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        User user = new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676");

        assertFalse(user.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        User user = new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676");
        User userTwo = new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676");

        assertThat(user, is(equalTo(userTwo)));
        assertThat(user.hashCode(), is(equalTo(userTwo.hashCode())));
    }
}