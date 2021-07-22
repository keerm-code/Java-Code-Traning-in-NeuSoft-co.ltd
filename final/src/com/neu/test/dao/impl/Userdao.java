package com.neu.test.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.test.dao.IUserdao;
import com.neu.test.pojo.impl.Employee;
import com.neu.test.pojo.impl.Question;
import com.neu.test.pojo.impl.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Userdao implements IUserdao {
    private ObjectMapper ob = new ObjectMapper();
    private Path user_path=Path.of("/home/tdt/桌面/2021.7实训/final/resource/user.json");
    private static Userdao userdao = new Userdao();

    private Userdao() {
    }

    public boolean add (User person) throws Exception {
        List<User> temp_list=new ArrayList<>();
        String person_js= Files.readString(user_path);
        if(person_js==null)
        {
            throw new Exception("json is null");
        }
        if(person_js.equals("")) {

        }
        else {
            temp_list=ob.readValue(person_js,  new TypeReference<List<User>>(){});
        }
        temp_list.add(person);
        ob.writeValue(user_path.toFile(),temp_list);
        return true;
    };
    public boolean delete(User person) throws IOException {
        String person_js = Files.readString(user_path);
        List<User> personList;
        personList=ob.readValue(person_js, new TypeReference<List<User>>() {});
        if(personList==null||personList.size()==0)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        Iterator i=personList.listIterator();
        while (i.hasNext())
        {
            User tempp=(User) i.next();
            if(tempp.getName().equals(person.getName()))
            {
                i.remove();
                return true;
            }
        }
        ob.writeValue(user_path.toFile(),personList);
        return false;
    }

    public void cover(List<User> personList) throws IOException {
        ob.writeValue(user_path.toFile(),personList);
    }

    public void change(User paper, User new_p) throws IOException {
        String person_js = Files.readString(user_path);
        List<User> personList;
        personList=ob.readValue(person_js, new TypeReference<List<User>>() {});
        if(personList==null||personList.size()==0)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        ListIterator i=personList.listIterator();
        while (i.hasNext())
        {
            User tempp=(User) i.next();
            if(tempp.getName().equals(paper.getName()))
            {
                i.remove();
                i.add(new_p);
            }
        }
        ob.writeValue(user_path.toFile(),personList);
    }

    public List<User> getall() throws IOException {
        String person_js = Files.readString(user_path);
        List<User> personList;
        if(person_js==null||person_js.length()==0)
        {
            return new ArrayList<>();
        }
        personList=ob.readValue(person_js, new TypeReference<List<User>>() {});
        return personList;
    }
    public static Userdao getInstance()
    {
        return userdao;
    }
}
