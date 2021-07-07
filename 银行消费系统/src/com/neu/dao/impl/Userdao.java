package com.neu.dao.impl;

import java.util.ArrayList;

import com.neu.pojo.impl.*;

public class Userdao {
    private ArrayList<Account> dao=new ArrayList<>();
    public void add_account(Account a)
    {
        dao.add(a);
    }
    public ArrayList<Account> get_accounts(String username)
    {
        ArrayList<Account> temp_as=new ArrayList<>();
        for (Account account : dao) {
            if(account.get_username().equals(username))
            {
                temp_as.add(account);
            }
        }
        return temp_as;
    }
    public int get_all_money(String username)
    {
        int temp=0;
        for (Account account : get_accounts(username)) {
            temp=temp+account.get_money();
        }
        return temp;
    }
}
