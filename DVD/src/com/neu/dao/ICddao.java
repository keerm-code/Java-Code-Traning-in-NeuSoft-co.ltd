package com.neu.dao;

import java.util. List;

import com.neu.pojo.imp.*;

public interface ICddao {
    void add_cd(Cd cd);
    boolean delete_cd (Cd cd);
    Cd find_cd(String cd_name);
     List<Cd> get_all_cds();
    int add_cost(Cd cd,int cost);
}
