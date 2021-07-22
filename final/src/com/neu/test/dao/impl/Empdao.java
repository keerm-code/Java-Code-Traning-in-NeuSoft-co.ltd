package com.neu.test.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.test.dao.IEmpdao;
import com.neu.test.pojo.impl.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class Empdao implements IEmpdao {
    private ObjectMapper ob = new ObjectMapper();
    private Path user_path=Path.of("/home/tdt/桌面/2021.7实训/final/resource/emp.json");
    private static Empdao userdao = new Empdao();

    private Empdao() {

    }

    public boolean add (Employee person) throws Exception {
        List<Employee> temp_list=new ArrayList<>();
        String person_js= Files.readString(user_path);
        if(person_js==null)
        {
            throw new Exception("json is null");
        }
        if(person_js.equals("")) {

        }
        else {
            try {
                temp_list=ob.readValue(person_js,  new TypeReference<List<Employee>>(){});
            } catch (JsonProcessingException e) {
                Files.writeString(user_path,"");
                temp_list= new ArrayList<>();
            }

        }
        temp_list.add(person);
        System.out.println(temp_list);
        ob.writeValue(user_path.toFile(),temp_list);
        return true;
    };
    public boolean delete(Employee person) throws IOException {
        String person_js = Files.readString(user_path);
        List<Employee> personList;
        personList=ob.readValue(person_js, new TypeReference<List<Employee>>() {});
        if(personList==null||personList.size()==0)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        Iterator i=personList.listIterator();
        while (i.hasNext())
        {
            Employee tempp=(Employee) i.next();
            if(tempp.getName().equals(person.getName()))
            {
                i.remove();
                return true;
            }
        }
        ob.writeValue(user_path.toFile(),personList);
        return false;
    }
    public Employee find(Employee person) throws IOException {
        String person_js = Files.readString(user_path);
        List<Employee> personList;
        if(person_js==null||person_js.length()==0)
        {
            IOException e=new IOException("json is null");
            return null;
        }
        personList=ob.readValue(person_js, new TypeReference<List<Employee>>() {});

        Iterator i=personList.listIterator();
        while (i.hasNext())
        {
            Employee tempp=(Employee) i.next();
            if(tempp.getName().equals(person.getName()))
            {
                return tempp;
            }
        }
        ob.writeValue(user_path.toFile(),personList);
        return null;
    }

    public void cover(List<Employee> personList) throws IOException {
        ob.writeValue(user_path.toFile(),personList);
    }
    public List<Employee> getall() throws IOException {
        String person_js = Files.readString(user_path);
        List<Employee> personList;
        if(person_js==null||person_js.length()==0)
        {
            return new ArrayList<>();
        }
        personList=ob.readValue(person_js, new TypeReference<List<Employee>>() {});
        return personList;
    }
    public static Empdao getInstance()
    {
        return userdao;
    }
}
