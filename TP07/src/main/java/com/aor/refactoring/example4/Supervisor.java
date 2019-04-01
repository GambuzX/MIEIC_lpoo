package com.aor.refactoring.example4;

import java.util.HashSet;
import java.util.Set;

public class Supervisor extends Person implements canLogin{
    private Set<Worker> supervisee;
    
    public Supervisor(String name, String phone, String username, String password) {
        super(name, phone, username, password);
        supervisee = new HashSet<>();
    }
    
    public void addSupervisee(Worker worker) {
        supervisee.add(worker);
    }

    public boolean isSupervisee(Worker worker) {
        return supervisee.contains(worker);
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
