package neu.service.imp;

import neu.pojo.imp.*;
import neu.service.IService;

public class Service implements IService{

    @Override
    public  int judge_who_win(User user,Bot bot) {//1玩家赢，2反之,0平局
        // TODO Auto-generated method stub
        if(user.get_fist().equals(bot.get_fist()))
        {
            return 0;
        }
        if(user.get_fist()==Fist.CLOTHES&&bot.get_fist()==Fist.ROCK)
        {
            return 1;
        }
        if(user.get_fist()==Fist.ROCK&&bot.get_fist()==Fist.SHEARS)
        {
            return 1;
        }
        if(user.get_fist()==Fist.SHEARS&&bot.get_fist()==Fist.CLOTHES)
        {
            return 1;
        }
        return 2;
    }
    public int get_result(User user,Bot bot)
    {
        if(user.get_score()==bot.get_score()){return 0;}
        return user.get_score()>bot.get_score()?1:2;
    }
}
