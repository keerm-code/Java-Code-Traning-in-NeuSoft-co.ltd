package com.neu.service;

import java.io.IOException;

import com.neu.pojo.imp.Cd;

public interface IService {
    void init() throws IOException;
    void add(Cd cd);
    boolean delete(Cd cd);
    int add_cost(Cd cd,int date);
    boolean lend_cd(Cd cd,int date);
    boolean return_cd(Cd cd,int date);
    void save_data() throws IOException;
    String show_all_cds();
}
