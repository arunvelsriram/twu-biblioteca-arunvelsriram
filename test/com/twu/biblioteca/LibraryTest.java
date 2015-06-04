package com.twu.biblioteca;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class LibraryTest {
    @Test
    public void shouldContainAListOfBooks() {
        Library library = new Library();

        List<Book> books = library.getBooks();

        assertThat(books, instanceOf(List.class));
    }
}