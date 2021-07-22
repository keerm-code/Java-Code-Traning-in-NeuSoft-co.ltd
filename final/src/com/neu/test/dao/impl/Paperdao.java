package com.neu.test.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.test.dao.IPaperdao;
import com.neu.test.pojo.impl.Employee;
import com.neu.test.pojo.impl.Paper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Paperdao implements IPaperdao {
    private ObjectMapper ob = new ObjectMapper();
    private Path user_path=Path.of("/home/tdt/桌面/2021.7实训/final/resource/paper.json");
    private static Paperdao userdao = new Paperdao();

    private Paperdao() {
    }

    public boolean add (Paper person) throws Exception {
        List<Paper> temp_list=new ArrayList<>();
        String person_js= Files.readString(user_path);
        if(person_js==null)
        {
            throw new Exception("json is null");
        }
        if(person_js.equals("")) {

        }
        else {
            temp_list=ob.readValue(person_js,  new TypeReference<List<Paper>>(){});
        }
        temp_list.add(person);
        ob.writeValue(user_path.toFile(),temp_list);
        return true;
    };
    public boolean delete(Paper paper) throws IOException {
        String person_js = Files.readString(user_path);
        List<Paper> personList;
        personList=ob.readValue(person_js, new TypeReference<List<Paper>>() {});
        if(personList==null||personList.size()==0)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        Iterator i=personList.listIterator();
        while (i.hasNext())
        {
            Paper tempp=(Paper) i.next();
            if(tempp.getId().equals(paper.getId()))
            {
                i.remove();
                return true;
            }
        }
        ob.writeValue(user_path.toFile(),personList);
        return false;
    }

    public Paper find(Paper paper) throws IOException {
        String person_js = Files.readString(user_path);
        List<Paper> personList;
        personList=ob.readValue(person_js, new TypeReference<List<Paper>>() {});
        if(personList==null||personList.size()==0)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        Iterator i=personList.listIterator();
        while (i.hasNext())
        {
            Paper tempp=(Paper) i.next();
            if(tempp.getId().equals(paper.getId()))
            {
                return tempp;
            }
        }
        return null;
    }

    public void change(Paper paper,Paper new_p) throws IOException {
        String person_js = Files.readString(user_path);
        List<Paper> personList;
        personList=ob.readValue(person_js, new TypeReference<List<Paper>>() {});
        if(personList==null||personList.size()==0)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        ListIterator i=personList.listIterator();
        while (i.hasNext())
        {
            Paper tempp=(Paper) i.next();
            if(tempp.getId().equals(paper.getId()))
            {
                i.remove();
                i.add(new_p);
            }
        }
        ob.writeValue(user_path.toFile(),personList);
    }

    public void cover(List<Paper> personList) throws IOException {
        ob.writeValue(user_path.toFile(),personList);
    }

    public List<Paper> getall() throws IOException {
        String person_js = Files.readString(user_path);
        List<Paper> personList;
        if(person_js==null||person_js.length()==0)
        {
            return new ArrayList<>();
        }
        personList=ob.readValue(person_js, new TypeReference<List<Paper>>() {});
        return personList;
    }
    public static Paperdao getInstance()
    {
        return userdao;
    }

}
