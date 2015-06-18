package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.User;

public interface Visitor {
    void visit(User user);
}