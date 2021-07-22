package com.neu.bike.service;

import com.neu.bike.pojo.impl.Bike;
import com.neu.bike.pojo.impl.Person;

import java.io.IOException;

public interface IService {
    int repair(Person person, Bike bike) throws Exception;
    int broke(Bike bike) throws Exception;
    int sign(Person person) throws Exception;
    int add_bike(Person person,Bike bike) throws IOException;
    int lend_bike(Bike bike);
//    int
}
