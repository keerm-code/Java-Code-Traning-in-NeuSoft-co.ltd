package com.neu.bike.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.bike.dao.IUserdao;
import com.neu.bike.pojo.impl.Bike;
import com.neu.bike.pojo.impl.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Userdao implements IUserdao {
    private ObjectMapper ob = new ObjectMapper();
    private Path user_path=Path.of("/home/tdt/桌面/2021.7实训/共享单车系统/resource/person.json");
    private static Userdao userdao = new Userdao();
    public boolean add (Person person) throws Exception {
        List<Person> temp_list=new ArrayList<>();
        String person_js= Files.readString(user_path);
        if(person_js==null)
        {
            throw new Exception("json is null");
        }
        if(person_js.equals("")) {

        }
        else {
            temp_list=ob.readValue(person_js,  new TypeReference<List<Person>>(){});
        }
        temp_list.add(person);
        ob.writeValue(user_path.toFile(),temp_list);
        return true;
    };
    public boolean delete(Person person) throws IOException {
        String person_js = Files.readString(user_path);
        List<Person> personList;
        personList=ob.readValue(person_js, new TypeReference<List<Person>>() {});
        if(personList==null||personList.size()==0)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        Iterator i=personList.listIterator();
        while (i.hasNext())
        {
            Person tempp=(Person) i.next();
            if(tempp.getName().equals(person.getName()))
            {
                i.remove();
                return true;
            }
        }
        ob.writeValue(user_path.toFile(),personList);
        return false;
    }

    public static Userdao getInstance()
    {
        return userdao;
    }
//      userdao test
//    public static void main(String[] args) throws Exception {
//        Person p=new Person();
//        Person a=new Person();
//        a.setPassword("er");
//        a.setName("dfcc");
//        p.setName("dfdf");
//        p.setPassword("123r");
//        Userdao.getInstance().add(p);
//        Userdao.getInstance().add(a);
//    }
}
