package com.neu.pojo.imp;

import com.neu.pojo.ICd;

public class Cd implements ICd{
    private String name;
    private boolean is_lend;
    private int cost;
    private int lend_date;
    public String get_name()
    {
        return this.name;
    }
    public boolean get_islend()
    {
        return this.is_lend;
    }
    public int get_cost()
    {
        return this.cost;
    }
    public void set_cost(int n)
    {
        cost=n;
    }
    public void  set_islend(Boolean b)
    {
        this.is_lend=b;
    }
    public int get_lenddate()
    {
        return lend_date;
    }
    public void set_lenddate(int date)
    {   
        this.lend_date=date;
    }
    public Cd(){};
    public Cd(String name)
    {
        this.name=name;
    }
    public Cd(String name,boolean is_lend,int cost,int date)
    {
        this.cost=cost;
        this.is_lend=is_lend;
        this.lend_date=date;
        this.name=name;
    }
    public String toString()
    {
        String temps="";
        temps=temps+this.name;
        temps=temps+"   ";
        temps=temps+Integer.toString(this.lend_date);
        temps=temps+"   ";
        temps=temps+Integer.toString(this.cost);
        temps=temps+"   ";
        if(is_lend){temps=temps+"is_lend";} 
        if(!is_lend){temps=temps+"not_lend";}
        return temps;

    }
    
}
