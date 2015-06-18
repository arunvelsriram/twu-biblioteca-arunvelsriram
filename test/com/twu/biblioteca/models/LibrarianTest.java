package com.twu.biblioteca.models;

import com.twu.biblioteca.controllers.Visitor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LibrarianTest {
    @Mock
    private Visitor visitorStub;

    private Librarian librarian;

    @Before
    public void setUp() {
        librarian = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");
    }

    @Test
    public void shouldBeAbleToIdentifyAValidUser() {
        boolean actual = librarian.valid("B1013", "pword");

        assertTrue(actual);
    }

    @Test
    public void shouldBeAbleToCheckTheUserName() {
        boolean actual = librarian.valid("B1111", "password");

        assertFalse(actual);
    }

    @Test
    public void shouldBeAbleToCheckThePassword() {
        boolean actual = librarian.valid("B1013", "password");

        assertFalse(actual);
    }

    @Test
    public void shouldBeAbleToCheckBothUserNameAndPassword() {
        boolean actual = librarian.valid("B1111", "pasword");

        assertFalse(actual);
    }

    @Test
    public void equalityShouldSatisfyReflexivity() {
        Librarian librarianOne = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");

        assertThat(librarianOne, is(equalTo(librarianOne)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        Librarian librarianOne = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");
        Librarian librarianTwo = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");

        assertThat(librarianOne, is(equalTo(librarianTwo)));
        assertThat(librarianTwo, is(equalTo(librarianOne)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        Librarian librarianOne = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");
        Librarian librarianTwo = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");
        Librarian librarianThree = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");

        assertThat(librarianOne, is(equalTo(librarianTwo)));
        assertThat(librarianTwo, is(equalTo(librarianThree)));
        assertThat(librarianOne, is(equalTo(librarianThree)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        Librarian librarianOne = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");

        assertFalse(librarianOne.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        Librarian librarianOne = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");

        assertFalse(librarianOne.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        Librarian guest = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");
        Librarian librarianTwo = new Librarian("B1013", "pword", "Priya", "priya33@gmail.com", "918989876767");

        assertThat(guest, is(equalTo(librarianTwo)));
        assertThat(guest.hashCode(), is(equalTo(librarianTwo.hashCode())));
    }

    @Test
    public void shouldBeVisitableByTheMenuDispatcher() {
        librarian.accept(visitorStub);

        verify(visitorStub).visit(librarian);
    }

    @Test
    public void shouldBeAbleToReturnAStatusMessage() {
        String actualMessage = librarian.statusMessage();

        assertThat(actualMessage, is(equalTo("Hi! You are logged in as Librarian.")));
    }
}