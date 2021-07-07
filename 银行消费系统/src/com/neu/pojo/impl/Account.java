package com.neu.pojo.impl;

import javax.print.DocFlavor.STRING;

import com.neu.pojo.IAccount;

public class Account implements IAccount{
    private String username;
    private int money;
    private String id;
    public Account(){};
    public Account(String name,int n)
    {
        this.money=n;
        this.username=name;
    }
    @Override
    public int get_money() {
        // TODO Auto-generated method stub
        return this.money;
    }
    @Override
    public String get_username() {
        // TODO Auto-generated method stub
        return this.username;
    }
    @Override
    public int take_money(int n) {
        if(n>this.money)
        {
            this.money=0;
            return (n-this.money);
        }
        this.money=this.money-n;
        return this.money;
    }
    public void set_id(String id)
    {
        this.id=id;
    }
    public void save_money(int n)
    {
        this.money=this.money+n;
    }
}