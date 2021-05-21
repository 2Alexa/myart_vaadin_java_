package com.example.application.backend.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Gefuehl extends AbstractEntity{
    private String name;

    @OneToMany(mappedBy = "gefuehl", fetch = FetchType.EAGER)
    private List<User> users = new LinkedList<>();

    public Gefuehl() {
    }

    public Gefuehl(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }
}
