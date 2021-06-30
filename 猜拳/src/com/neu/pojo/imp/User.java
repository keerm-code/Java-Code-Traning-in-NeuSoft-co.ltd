package neu.pojo.imp;

import java.io.IOException;

import neu.pojo.IPlayer;

public class User implements IPlayer {
    private String name;
    private Fist fist;
    private int score;
    public User()
    {
        
    };
    public User(String name)
    {
        this.name=name;
        this.score=0;
    }
    public String get_name()
    {
        return this.name;
    }
    public Fist get_fist()
    {
        return this.fist;
    }
    public int get_score()
    {
        return this.score;
    }
    public void add_score()
    {
        this.score++;
    }
    @Override
    public void bet(String fist) throws Exception {
        if(fist.equals("0"))
        {
            this.fist= Fist.ROCK;
        }
        else if(fist.equals("1"))
        {
            this.fist= Fist.SHEARS;
        }
        else if(fist.equals("2"))
        {
            this.fist= Fist.CLOTHES;
        }
        else
        {
            throw new Exception("用户输入不合法，请重新输入");
        }
    }
}
