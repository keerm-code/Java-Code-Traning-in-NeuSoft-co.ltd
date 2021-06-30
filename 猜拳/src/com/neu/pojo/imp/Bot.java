package neu.pojo.imp;

import neu.pojo.IPlayer;

public class Bot implements IPlayer{
    private String name;
    private Fist fist;
    private int score;
    public Fist get_fist()
    {
        return this.fist;
    }
    public String get_name()
    {
        return this.name;
    }
    public Bot()
    {
        this.name="BOT";
        this.score=0;
    }
    public int get_score()
    {
        return this.score;
    }
    @Override
    public void bet(String fist) throws Exception{
        int flag=((int)(Math.random()*1000))%3;
        if(flag==0)
        {
            this.fist= Fist.ROCK;
            return;
        }
        if(flag==1)
        {
            this.fist= Fist.SHEARS;
            return;
        }
        this.fist= Fist.CLOTHES;
        
    }
    public void add_score() {
        this.score++;
    }
    
}
