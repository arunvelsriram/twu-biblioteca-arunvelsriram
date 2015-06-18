package com.twu.biblioteca.models;

import java.util.List;

public class Users {
    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public User authenticate(String libraryNumber, String password) {
        return search(libraryNumber, password);
    }

    private User search(String libraryNumber, String password) {
        for (User user : users) {
            if(user.valid(libraryNumber, password)) {
                return user;
            }
        }
        return new Guest();
    }
}