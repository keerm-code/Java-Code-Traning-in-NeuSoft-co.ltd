package com.neu.service.impl;

import com.neu.dao.impl.*;
import com.neu.pojo.impl.*;

public class Service {
    public Userdao dao=new Userdao();
    public void save(User u,int n)
    {
        for (Account a : dao.get_accounts(u.get_name())) {
            if(a.getClass().equals(new Saveaccount().getClass()))
            {
                a.save_money(n);
                return;
            }
        }
    }
    public boolean cost(User u,int n)
    {
        if(!can_afford(u, n))
        {
            return false;
        }
        int flag=-n;
        for (Account a : dao.get_accounts(u.get_name())) {
            if(a.getClass().equals(new Criditaccount().getClass()))
            {
                flag=a.take_money(-flag);
                if(flag<0)
                {
                    continue;
                }
                break;
            }
        }
        if(flag<0)
        {
            for (Account a : dao.get_accounts(u.get_name())) {
                if(a.getClass().equals(new Saveaccount().getClass()))
                {
                    flag=a.take_money(-flag);
                    if(flag<0)
                    {
                        continue;
                    }
                    break;
                }
            }
        }
        return true;
    }
    public boolean can_afford(User u,int n)
    {
        return (dao.get_all_money(u.get_name())>=n)?true:false;
    }
}
