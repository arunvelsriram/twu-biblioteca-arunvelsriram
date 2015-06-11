package com.twu.biblioteca.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void shouldBeAbleToReturnBookDetail() throws Exception {
        Book book = new Book("Harry Potter and The Sorcer's Stone", "JK Rowling", 1999);

        String actualBook = book.toString();

        assertThat(actualBook, is(equalTo("| Harry Potter and The Sorcer's Stone | JK Rowling | 1999 |")));
    }

    @Test
    public void equalityShouldSatisfyReflexivity() {
        Book bookOne= new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);

        assertThat(bookOne, is(equalTo(bookOne)));
    }

    @Test
    public void equalityShouldSatisfySymmetricity() {
        Book bookOne = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);
        Book bookTwo = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);

        assertThat(bookOne, is(equalTo(bookTwo)));
        assertThat(bookTwo, is(equalTo(bookOne)));
    }

    @Test
    public void equalityShouldSatisfyTransitivity() {
        Book bookOne = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);
        Book bookTwo = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);
        Book bookThree = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);

        assertThat(bookOne, is(equalTo(bookTwo)));
        assertThat(bookTwo, is(equalTo(bookThree)));
        assertThat(bookOne, is(equalTo(bookThree)));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingNull() {
        Book bookOne = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);

        assertFalse(bookOne.equals(null));
    }

    @Test
    public void equalityShouldReturnFalseOnPassingOtherObject() {
        Book bookOne = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);

        assertFalse(bookOne.equals(new String("Hello, World")));
    }

    @Test
    public void whenTwoObjectsAreEqualThenTheirHashCodeMustBeEqual() {
        Book bookOne = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);
        Book bookTwo = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);

        assertThat(bookOne, is(equalTo(bookTwo)));
        assertThat(bookOne.hashCode(), is(equalTo(bookTwo.hashCode())));
    }

    @Test
    public void shouldBeAbleToTellIfABookExists() throws Exception {
        Book book = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);

        assertTrue(book.exists("Harry Potter an The Sorcer's Stone"));
    }

    @Test
    public void shouldBeAbleToTellIfABookDoesNotExist() throws Exception {
        Book book = new Book("Harry Potter an The Sorcer's Stone", "JK Rowling", 1999);

        assertFalse(book.exists("Twilight"));
    }
}