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
    private List<User> userDetails;

    @Before
    public void setUp() {
        userDetails = new ArrayList<>();
        userDetails.add(new Librarian("B1012", "password", "Arun", "arunvelsriram@gmail.com", "919629722335"));
        userDetails.add(new Member("B1011", "passwd", "Murali", "murali123@gmail.com", "919976767676"));
        users = new Users(userDetails);
    }

    @Test
    public void shouldBeAbleToReturnAnEmptyListOnUnsuccessfulAuthenticationDueToWrongPassword() {
        User expectedResult = new Guest();

        User actualResult = users.authenticate("B1012", "wrongpasswd");

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldBeAbleToReturnAnEmptyListOnUnsuccessfulAuthenticationDueToWrongLibraryNumber() {
        User expectedResult = new Guest();

        User actualResult = users.authenticate("SomeNumber", "password");

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldBeAbleToReturnAnEmptyListOnUnsuccessfulAuthenticationDueToWrongLibraryNumberAndPassword() {
        User expectedResult = new Guest();

        User actualResult = users.authenticate("SomeNumber", "Some Password");

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldBeAbleToReturnAListOfUsersOnSuccessfulAuthentication() {
        User expectedResult = userDetails.get(0);

        User actualResult = users.authenticate("B1012", "password");

        assertThat(actualResult, is(equalTo(expectedResult)));
    }
}