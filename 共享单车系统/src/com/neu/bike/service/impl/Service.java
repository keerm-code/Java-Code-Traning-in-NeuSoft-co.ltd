package com.neu.bike.service.impl;

import com.neu.bike.dao.impl.Bikedao;
import com.neu.bike.dao.impl.Userdao;
import com.neu.bike.pojo.IPerson;
import com.neu.bike.pojo.impl.Bike;
import com.neu.bike.pojo.impl.Person;
import com.neu.bike.service.IService;

import java.io.IOException;

public class Service implements IService {

    private Userdao userdao=new Userdao();
    private Bikedao bikedao=new Bikedao();

    @Override
    public int repair(Person person, Bike bike) throws Exception {
        if(person.getType().equals(IPerson.TYPE.SUPPLIER))
        {
            if(bikedao.search(bike).isIs_broken())
            {
                bike.setIs_broken(false);
                bikedao.change(bike);
                return 1;//success
            }
            return 0;//not broken
        }
        return -1;//have no right
    }

    @Override
    public int broke(Bike bike) throws Exception {
            if(!bikedao.search(bike).isIs_broken())
            {
                bike.setIs_broken(true);
                bikedao.change(bike);
                return 1;//success
            }
            return 0;//already broken
    }

    @Override
    public int sign(Person person) throws Exception {
        userdao.add(person);
        return 1;//success
    }

    @Override
    public int add_bike(Person person, Bike bike) throws IOException {
        if(person.getType()== IPerson.TYPE.USER||person.getType()== IPerson.TYPE.SERVICER)
        {
            return -1;
        }
        else {
            bikedao.add(bike);
        }
        return 1;
    }

    @Override
    public int lend_bike(Bike bike) {
        return 0;
    }
}
