package com.neu.test.pojo.impl;

import com.neu.test.pojo.IEmployee;

import java.util.Objects;

public class Employee implements IEmployee{
    String name;
    String key;
    String type;
    String id;
    String level;
    String talent;
    String phone;
    Boolean is_select;

    public Employee(String name, String key, String type) {
        this.name = name;
        this.key = key;
        this.type = type;
    }

    public Employee(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public Employee() {
        this.name="";
        this.key="";
        this.type="";
    }

    public Employee(String name, String key, String type, String id, String level, String talent, String phone) {
        this.name = name;
        this.key = key;
        this.type = type;
        this.id = id;
        this.level = level;
        this.talent = talent;
        this.phone = phone;
        this.is_select=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(key, employee.key) && Objects.equals(type, employee.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, key, type);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIs_select() {
        return is_select;
    }

    public void setIs_select(Boolean is_select) {
        this.is_select = is_select;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", level='" + level + '\'' +
                ", talent='" + talent + '\'' +
                ", phone='" + phone + '\'' +
                ", is_select=" + is_select +
                '}';
    }
}