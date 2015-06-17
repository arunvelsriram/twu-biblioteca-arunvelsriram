package com.twu.biblioteca.models;

import java.util.Arrays;

public class User {
    private String libraryNumber;
    private char[] password;
    private String name;
    private String emailAddress;
    private String phoneNumber;

    public User(String libraryNumber, char[] password, String name, String emailAddress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public boolean valid(String libraryNumber, char[] password) {
        return validUser(libraryNumber, password) ? true : false;
    }

    private boolean validUser(String libraryNumber, char[] password) {
        return libraryNumber.equals(this.libraryNumber) && Arrays.equals(password, this.password);
    }
}