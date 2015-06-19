package com.twu.biblioteca.models;

import com.twu.biblioteca.controllers.Visitor;

public class Member extends User{
    public Member(String libraryNumber, String password, String name, String emailAddress, String phoneNumber) {
        super(libraryNumber, password, name, emailAddress, phoneNumber);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String statusMessage() {
        return "Hi! You are logged in as Member.";
    }
}