package com.neu.test.pojo.impl;

import com.neu.test.pojo.*;

public class User implements IUser{
    Boolean is_select;
    String id;
    String name;
    String sex;
    String phone;
    String contractor;//
    String contractphone;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    String age;
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public User( String id, String name, String sex, String phone, String contractor, String contractphone,String age) {
        this.is_select = false;
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.contractor = contractor;
        this.contractphone = contractphone;
        this.age=age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getContractphone() {
        return contractphone;
    }

    public void setContractphone(String contractphone) {
        this.contractphone = contractphone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", contractor='" + contractor + '\'' +
                ", contractphone='" + contractphone + '\'' +
                '}';
    }

    public Boolean getIs_select() {
        return is_select;
    }

    public void setIs_select(Boolean is_select) {
        this.is_select = is_select;
    }
}