package com.neu.pojo;

public interface IAccount {
    int get_money();
    String get_username();
    int take_money(int n);
    //void create_id();
    public void set_id(String id);
}
