package com.twu.biblioteca.dispatchers;

import com.twu.biblioteca.models.Guest;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.Member;

public interface Dispatcher {
    void dispatch(Guest guest);
    void dispatch(Librarian librarian);
    void dispatch(Member member);
}