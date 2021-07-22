package com.neu.bike.pojo.impl;

import com.neu.bike.pojo.IPerson;


public class Person implements IPerson {

    private String name;
    private String password;
    private TYPE type;

    public Person() {
    }

    public Person(String name, String password, TYPE type) {
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}
