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
        return libraryNumber.equals(this.libraryNumber) && Arrays.equals(password, this.password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!libraryNumber.equals(user.libraryNumber)) return false;
        if (!Arrays.equals(password, user.password)) return false;
        if (!name.equals(user.name)) return false;
        if (!emailAddress.equals(user.emailAddress)) return false;
        return phoneNumber.equals(user.phoneNumber);

    }

    @Override
    public int hashCode() {
        int result = libraryNumber.hashCode();
        result = 31 * result + Arrays.hashCode(password);
        result = 31 * result + name.hashCode();
        result = 31 * result + emailAddress.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }
}