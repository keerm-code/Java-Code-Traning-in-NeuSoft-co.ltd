package com.neu.dao.impl;

// import java.lang.reflect.Array;
import java.util.Arrays;

import com.neu.dao.IUserDao;
import com.neu.pojo.User;

//数据访问类
public class UserDao implements IUserDao {

    private User[] users = new User[0];

    @Override
    public void add(User user) {
        System.out.println("操作数组");
        users=Arrays.copyOf(users, users.length+1);
        users[users.length-1]=user;
    }

    @Override
    public User findByUsername(String username) {
        for(User e:users)
        {
            if(e.get_name().equals(username))
            {
                return e;
            }
        }
        User a=new User("\n","\n");
        return a;
    }
}
