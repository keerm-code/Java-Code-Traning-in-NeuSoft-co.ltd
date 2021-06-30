package neu.ui;

import java.util.Scanner;

import neu.pojo.imp.*;
import neu.service.imp.*;

public class Ui {
    public static void main(String[] args) 
    {
        while(true){
            Ui ui=new Ui();
            User user=new User();
            Bot bot=new Bot();
            Service service=new Service();
            String username=ui.input("请输入用户名");
            user=new User(username);
            int time_counts=0;
            while(true)
            {
                String selction=ui.input("连续猜拳，继续请按1，中断并计算得分请按0");
                if(selction.equals("1"))
                {
                    selction=ui.input("请选择出什么拳（0.石头，1，剪刀，2，布）");
                    try {
                        user.bet(selction);
                        bot.bet(selction);
                        System.out.printf("玩家%s"+"出："+user.get_fist()+"     玩家%s"+"出:"+bot.get_fist()
                        +"\n",user.get_name(),bot.get_name());
                    } catch (Exception e) {
                        //TODO: handle exception
                        System.out.println(e.getMessage());
                        break;
                    }

                    if(service.judge_who_win(user, bot)==1)
                    {
                        System.out.println("玩家"+user.get_name()+"获胜");
                        user.add_score();
                        System.out.println("目前玩家积分为："+user.get_name()+" "+
                        user.get_score()+"     "+bot.get_name()+" "+bot.get_score());
                    }
                    else if(service.judge_who_win(user, bot)==2)
                    {
                        System.out.println("玩家"+bot.get_name()+"获胜");
                        bot.add_score();
                        System.out.println("目前玩家积分为："+user.get_name()+" "+
                        user.get_score()+"     "+bot.get_name()+" "+bot.get_score());
                    }
                    else{
                        System.out.println("本局平局");
                        System.out.println("目前玩家积分为："+user.get_name()+" "+
                        user.get_score()+"     "+bot.get_name()+" "+bot.get_score());
                    }
                    time_counts++;
                }
                else if(selction.equals("0"))
                {
                    System.out.println("目前玩家积分为："+user.get_name()+" "+
                    user.get_score()+"     "+bot.get_name()+" "+bot.get_score());
                    if(service.get_result(user, bot)==1)
                    {
                        System.out.println("因此，"+user.get_name()+"赢了");
                    }
                    else if(service.get_result(user, bot)==2)
                    {
                        System.out.println("因此，"+bot.get_name()+"赢了");
                    }
                    else
                    {
                        System.out.println("两玩家平局");
                    }
                    System.out.println("对局结束");
                    break;
                }
                else
                {
                    System.err.println("输入类型非法，请重新输入");
                }

            }
        }
    }
    public String input(String outtext)
    {
        System.out.print(outtext+":");
        Scanner sc=new Scanner(System.in);
        return sc.next();
    }
}
