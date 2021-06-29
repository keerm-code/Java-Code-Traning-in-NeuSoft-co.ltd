package com.neu.dao;


import com.neu.pojo.User;

//数据访问接口
public interface IUserDao {

    //添加用户
    void add(User user);

    //用户名获取用户
    User findByUsername(String username);
}
