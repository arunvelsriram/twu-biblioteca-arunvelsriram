package com.twu.biblioteca.models;

import com.twu.biblioteca.MenuItemAction;

public class MenuItem {
    private String name;
    private MenuItemAction menuItemAction;

    public MenuItem(String name, MenuItemAction menuItemAction) {
        this.name = name;
        this.menuItemAction = menuItemAction;
    }

    public void performAction() {
        menuItemAction.performAction();
    }

    public boolean isExit() {
        return (this.name.compareToIgnoreCase("quit") == 0);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MenuItem)) return false;

        MenuItem menuItem = (MenuItem) object;

        return !(name != null ? !name.equals(menuItem.name) : menuItem.name != null) && !(menuItemAction != null ?
                !menuItemAction.equals(menuItem.menuItemAction) : menuItem.menuItemAction != null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (menuItemAction != null ? menuItemAction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        return sb.toString();
    }
}