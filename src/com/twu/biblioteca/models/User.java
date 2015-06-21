package com.twu.biblioteca.models;

import com.twu.biblioteca.dispatchers.Dispatcher;

public abstract class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String emailAddress;
    private String phoneNumber;

    public User(String libraryNumber, String password, String name, String emailAddress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public boolean valid(String libraryNumber, String password) {
        return libraryNumber.equals(this.libraryNumber) && password.equals(this.password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!libraryNumber.equals(user.libraryNumber)) return false;
        if (!password.equals(user.password)) return false;
        if (!name.equals(user.name)) return false;
        if (!emailAddress.equals(user.emailAddress)) return false;
        return phoneNumber.equals(user.phoneNumber);

    }

    @Override
    public int hashCode() {
        int result = libraryNumber.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + emailAddress.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library Number: ").append(libraryNumber).append("\n")
                .append("Name: ").append(name).append("\n")
                .append("Email Address: ").append(emailAddress).append("\n")
                .append("Phone number: ").append(phoneNumber).append("\n");
        return sb.toString();
    }

    public abstract void accept(Dispatcher dispatcher);

    public abstract String statusMessage();
}