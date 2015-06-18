package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> authenticate(String libraryNumber, char[] password) {
        return search(libraryNumber, password);
    }

    private List<User> search(String libraryNumber, char[] password) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if(user.valid(libraryNumber, password)) {
                   result.add(user);
            }
        }
        return result;
    }
}