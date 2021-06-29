package com.neu.pojo;



public class User {
    public static String get_key;
    //成员变量
    private String name;//用户名
    private String key;//密码
    private Integer id;//用户id
    private boolean flag=false;//是否登陆
    //方法，get/set方法如名所述
    public String get_name(){return this.name;};
    public int get_id(){return this.id;};
    public String get_key(){return this.key;};
    public void set_name(String name)
    {
        this.name=name;
    };

    public void set_key(String key)
    {
        this.key=key;
    };
    public void set_id(Integer a)
    {
        this.id=a;
    }
    public User(String name,String key)
    {
        set_key(key);
        set_name(name);
    }//user构造函数（需要加public否则跑不通？）
    // public void sign_up()
    // {
        
    // };
    // public boolean sign_in(String key)
    // {
    //     return true;
    // };
    // public boolean lottery(int guess)
    // {
    //     Lotter_machine init_lotter=new Lotter_machine();
    //     for(int i:init_lotter.get_lottery_today())
    //     {
    //         if(i==guess)
    //         {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public boolean eqeals(User user)
    {
        return (this.get_name().equals(user.get_name()))&&(this.id==user.get_id())?true:false;
    }//重载的eqeals方法，姓名id一样判定为同一用户
}