package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutHistory {
    private Map<User, List<Item>> history;

    public CheckoutHistory(Map<User, List<Item>> history) {
        this.history = history;
    }

    public boolean has(User user, Item item) {
        if(history.containsKey(user)) {
            List<Item> items = history.get(user);
            return items.contains(item);
        }
        return false;
    }

    public void store(User user, Item item) {
        if (history.containsKey(user)) {
            history.get(user).add(item);
        } else {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<User, List<Item>> entry : history.entrySet()) {
            User user = entry.getKey();
            List<Item> items = entry.getValue();
            sb.append("***User Details***\n");
            sb.append(user).append("\n");
            for (Item item : items) {
                sb.append("***Item Details***\n");
                sb.append(item);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}