package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutHistory {
    private Map<User, List<Item>> history;

    public CheckoutHistory(Map<User, List<Item>> history) {
        this.history = history;
    }

    public void store(User user, Item item) {
        if(history.containsKey(user)) {
            history.get(user).add(item);
        }
        else {
            List<Item> items = new ArrayList<>();
            items.add(item);
            history.put(user, items);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckoutHistory)) return false;

        CheckoutHistory that = (CheckoutHistory) o;

        return history.equals(that.history);

    }

    @Override
    public int hashCode() {
        return history.hashCode();
    }
}