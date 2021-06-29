package com.neu.view;

import java.util.Scanner;
import com.neu.pojo.*;
import com.neu.service.impl.UserService;


public class SystemUI {

    public static void main(String[] args) {
        SystemUI ui = new SystemUI();//初始化对象
        UserService service=new UserService();//初始化可用的服务
        while(true)//无限循环直至停止
        badstring1:{
            String x="请选择要使用的功能(1.注册 2.登陆 3.退出本页面)";
            String selection=ui.input(x);
            if(selection.equals("1"))
            {
                String username = ui.input("请输入用户名");
                String key=ui.input("请输入密码");
                User user=new User(username,key);
                service.regist(user);
                // Integer temp_ids=new Integer(user.get_id());
                System.out.println("注册成功，您的id是"+Integer.toString(user.get_id()));
                break badstring1;//回到最初界面
            };
            if(selection.equals("2"))
            {
                String username = ui.input("请输入用户名");
                String key=ui.input("请输入密码");
                User user=new User(username,key);
                if(service.login(user).get_name().equals(username))
                user=service.login(user);
                badstring2:{
                    
                    selection=ui.input("登陆成功，请选择要使用的功能（1.抽奖 2.退出本页面）");
                    if(selection.equals("1"))
                    {
                        String temp_id=ui.input("请输入您的id");
                        // Integer temp_userid=new Integeruser.get_id());
                        
                        if(!temp_id.equals(Integer.toString(service.login(user).get_id())))
                        {
                            System.out.println("id错误,请重新输入");
                            break badstring2;
                        }
                        System.out.println("今日的幸运数字为：");
                        for(int i=0;i<service.lottery(user).length-1;i++)
                        {
                            System.out.println(service.lottery(user)[i]+" ");
                        }
                        boolean is_win=(boolean)
                        service.lottery(user)[service.lottery(user).length-1];
                        if(is_win)
                        {
                            System.out.println("\n您中奖了");
                        }
                        else
                        {
                            System.out.println("\n您没中奖");
                        }
                        break badstring1;
                    }
                    if(selection.equals("2"))
                    {
                        break badstring1;
                    }
                    else
                    {
                        System.out.println("输入错误，请重新输入");
                        break badstring2;
                    }
                }
            }
            if(selection.equals("3"))
            {
                return;
            }
            // String username = ui.input("请输入用户名");
            // String key=ui.input("请输入密码");
            // User user=new User(username,key);
        }
    }

    //提供一个提示，接收控制台输入，返回输入结果
    private String input(String tip){
        Scanner input = new Scanner(System.in);
        System.out.print(tip + ":");
        return input.next();
    }
}
