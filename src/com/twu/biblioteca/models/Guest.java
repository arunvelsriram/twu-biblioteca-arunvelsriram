package com.twu.biblioteca.models;

import com.twu.biblioteca.controllers.Visitor;

public class Guest extends User {
    public Guest() {
        super("", "", "", "", "");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}