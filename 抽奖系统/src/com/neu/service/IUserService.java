package com.neu.service;

import com.neu.pojo.User;
// import com.neu.dao.impl.UserDao;


//业务接口
public interface IUserService {

    //登录
    User login(User user);

    //注册
    boolean regist(User user);

    //抽奖 return: 5个数的数组，中奖结果
    Object[] lottery(User loginUser);
}
