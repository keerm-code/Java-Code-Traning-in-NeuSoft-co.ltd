package com.neu.service.impl;

import com.neu.pojo.User;
import com.neu.service.IUserService;
import com.neu.dao.impl.UserDao;



//业务实现类
public class UserService implements IUserService {
    UserDao dao=new UserDao();
    @Override
    public User login(User user) {
        user=dao.findByUsername(user.get_name());
        user.set_id(dao.findByUsername(user.get_name()).get_id());
        return dao.findByUsername(user.get_name());
    }

    @Override
    public boolean regist(User user) {
        create_user_id(user);
        dao.add(user);
        return true;
    }

    @Override
    public Object[] lottery(User loginUser) {
        Object[] return_array=new Object[5];
        for(int i=0;i<return_array.length-1;i++)
        {
            return_array[i]=(int)(Math.random()*9000+1000);
        }
        boolean flag=false;
        for (Object object : return_array) {
            Integer temp_id=loginUser.get_id();
            if(object==temp_id)
            {
                flag=true;
            }
        }
        return_array[return_array.length-1]=flag;
        return return_array;
    }
    public void create_user_id(User user)
    {
        user.set_id((int)(Math.random()*9000)+1000);
    };
}
