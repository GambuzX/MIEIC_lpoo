package com.aor.refactoring.example4;

public class Worker extends Person {

    public Worker(String name, String phone, String username, String password) {
        super(name, phone, username, password);
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
