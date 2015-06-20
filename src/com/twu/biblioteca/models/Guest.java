package com.twu.biblioteca.models;

import com.twu.biblioteca.controllers.Dispatcher;

public class Guest extends User {
    public Guest() {
        super("", "", "", "", "");
    }

    @Override
    public void accept(Dispatcher dispatcher) {
        dispatcher.dispatch(this);
    }

    @Override
    public String statusMessage() {
        return "Login failed!";
    }

    @Override
    public String toString() {
        return "";
    }
}