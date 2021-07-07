package com.neu.view;

import java.util.Scanner;

import com.neu.pojo.impl.User;
import com.neu.service.impl.Service;

public class Ui {
    public static void main(String[] args) {
        Ui ui=new Ui();
        Service serv=new Service();
        
        while(true)
        {
            String username=ui.input("银行消费系统，请输入用户名，输入0退出");
            if(username.equals("0"))
            {
                return;
            }
            User u=new User(username);
            String n=ui.input("请输入需要消费的金额");
            if(serv.cost(u, Integer.valueOf(n)))
            {
                System.out.println("消费成功");
            }
            else
            {
                System.out.println("消费失败");
            }
            
        }
        
        

    }
    //提供一个提示，接收控制台输入，返回输入结果
    private String input(String tip){
        Scanner input = new Scanner(System.in);
        System.out.print(tip + ":");
        return input.next();
    }
    
}
