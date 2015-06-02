package com.twu.biblioteca;

public class BibliotecaApp {

    public BibliotecaApp() {
        System.out.println(welcomeMessage());
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
    }

    public String welcomeMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to Biblioteca - A Library Management System\n");
        int length = sb.length();
        for (int i = 0; i < length; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}