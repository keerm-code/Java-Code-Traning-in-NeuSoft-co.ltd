package com.neu.dao.imp;

import java.util.ArrayList;
import java.util. List;

import com.neu.dao.ICddao;
import com.neu.pojo.imp.Cd;

public class Cddao implements ICddao{

     List<Cd> cddao=new  ArrayList<>();
    @Override
    public void add_cd(Cd cd) {
        
        cddao.add(cd);
    }

    @Override
    public boolean delete_cd(Cd cd) {
        
        if(this.find_cd(cd.get_name()).equals(null))
        {
            return false;
        }
        else
        {
            for (int i=0;i<cddao.size();i++){
                if(cddao.get(i).get_name().equals(cd.get_name()))
                {
                    cddao.remove(i);
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public Cd find_cd(String cd_name) {
         
        for (Cd cd : cddao) {
            if(cd.get_name().equals(cd_name))
            {
                return cd;
            }
        }
        return null;
    }

    @Override
    public  List<Cd> get_all_cds() {
         
        return cddao;
    }

    @Override
    public int add_cost(Cd cd, int date) {
         
        if(!this.find_cd(cd.get_name()).equals(null))
        {
            for (Cd cd2 : cddao) {
                if(cd2.get_name().equals(cd.get_name()))
                {
                    cd2.set_cost(cd2.get_cost()+(date-cd2.get_lenddate())*5);
                    return cd2.get_cost();
                }
            }
        }
        return 0;
    }
    
    
}
