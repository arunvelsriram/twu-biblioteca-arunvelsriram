package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Guest;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.Member;

public interface Visitor {
    void visit(Guest guest);
    void visit(Librarian librarian);
    void visit(Member member);
}