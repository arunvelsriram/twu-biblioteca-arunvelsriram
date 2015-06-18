package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UsersTest {

    private Users users;

    @Before
    public void setUp() {
        List<User> userDetails = new ArrayList<>();
        userDetails.add(new User("B1012", "password".toCharArray(), "Arun", "arunvelsriram@gmail.com", "919629722335"));
        userDetails.add(new User("B1011", "passwd".toCharArray(), "Murali", "murali123@gmail.com", "919976767676"));
        users = new Users(userDetails);
    }

    @Test
    public void shouldBeAbleToReturnAnEmptyListOnUnsuccessfulAuthenticationDueToWrongPassword() {
        List<User> expectedResult = new ArrayList<>();

        List<User> actualResult = users.authenticate("B1012", "wrongpasswd".toCharArray());

        assertThat(expectedResult, is(equalTo(actualResult)));
    }

    @Test
    public void shouldBeAbleToReturnAnEmptyListOnUnsuccessfulAuthenticationDueToWrongLibraryNumber() {
        List<User> expectedResult = new ArrayList<>();

        List<User> actualResult = users.authenticate("SomeNumber", "password".toCharArray());

        assertThat(expectedResult, is(equalTo(actualResult)));
    }

    @Test
    public void shouldBeAbleToReturnAnEmptyListOnUnsuccessfulAuthenticationDueToWrongLibraryNumberAndPassword() {
        List<User> expectedResult = new ArrayList<>();

        List<User> actualResult = users.authenticate("SomeNumber", "Some Password".toCharArray());

        assertThat(expectedResult, is(equalTo(actualResult)));
    }

    @Test
    public void shouldBeAbleToReturnAListOfUsersOnSuccessfulAuthentication() {
        List<User> expectedResult = new ArrayList<>();
        expectedResult.add(new User("B1012", "password".toCharArray(), "Arun", "arunvelsriram@gmail.com", "919629722335"));

        List<User> actualResult = users.authenticate("B1012", "password".toCharArray());

        assertThat(expectedResult, is(equalTo(actualResult)));
    }
}