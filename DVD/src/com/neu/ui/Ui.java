package com.neu.ui;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import com.neu.pojo.imp.*;
import com.neu.service.imp.*;


public class Ui {
    public static void main(String[] args) throws IOException {
        Ui ui=new Ui();
        Service serv=new Service();
        try {
            serv.init();
        } catch (Exception e) {
            System.out.println(e);
        }
        while(true)
        {
            System.out.println("欢迎进入cd管理系统");
            System.out.println("请输入对应数字使用对应功能");
            System.out.println("1.查看所有cd");
            System.out.println("2.借出cd");
            System.out.println("3.归还cd");
            System.out.println("4.添加cd");
            System.out.println("5.删除cd");
            System.out.println("6.退出系统");
            String selection=ui.input("请输入选项");
            if (selection.equals("1")) 
            {
                System.out.println(serv.show_all_cds());
            } 
            if(selection.equals("2"))
            {
                String cdname=ui.input("请输入要借出的cd名");
                Cd tempcd=new Cd(cdname);
                int date=(int)System.currentTimeMillis();
                if(!serv.lend_cd(tempcd, date))
                {
                    System.out.println("该cd不存在");
                };
            }
            if(selection.equals("3"))
            {
                String cdname=ui.input("请输入要归还的cd名");
                Cd tempcd=new Cd(cdname);
                int date=(int)System.currentTimeMillis();
                int cost=serv.add_cost(tempcd, date);
                if(cost==0)
                {
                    System.out.println("该cd不存在");
                    break;
                };
                serv.return_cd(tempcd, date);
                
            }
            if(selection.equals("4"))
            {
                String cdname=ui.input("请输入要添加的cd名");
                Cd tempcd=new Cd(cdname);
                serv.add(tempcd);
                System.out.println("添加成功");
            }
            if(selection.equals("5"))
            {
                String cdname=ui.input("请输入要删除的cd名");
                Cd tempcd=new Cd(cdname);
                if(!serv.delete(tempcd))
                {
                    System.out.println("该cd不存在");
                    break;
                }
                System.out.println("删除成功");
            }
            if (selection.equals("6")) {
                serv.save_data();
                return;
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