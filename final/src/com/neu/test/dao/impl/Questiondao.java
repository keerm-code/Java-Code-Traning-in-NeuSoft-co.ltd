package com.neu.test.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.test.dao.IQuestiondao;
import com.neu.test.pojo.impl.Employee;
import com.neu.test.pojo.impl.Paper;
import com.neu.test.pojo.impl.Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Questiondao implements IQuestiondao {
    private ObjectMapper ob = new ObjectMapper();
    private Path user_path=Path.of("/home/tdt/桌面/2021.7实训/final/resource/qust.json");
    private static Questiondao userdao = new Questiondao();

    private Questiondao() {
    }

    public boolean add (Question person) throws Exception {
        List<Question> temp_list=new ArrayList<>();
        String person_js= Files.readString(user_path);
        if(person_js==null)
        {
            throw new Exception("json is null");
        }
        if(person_js.equals("")) {

        }
        else {
            temp_list=ob.readValue(person_js,  new TypeReference<List<Question>>(){});
        }
        temp_list.add(person);
        ob.writeValue(user_path.toFile(),temp_list);
        return true;
    };
    public boolean delete(Question paper) throws IOException {
        String person_js = Files.readString(user_path);
        List<Question> personList;
        personList=ob.readValue(person_js, new TypeReference<List<Question>>() {});
        if(personList==null||personList.size()==0)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        Iterator i=personList.listIterator();
        while (i.hasNext())
        {
            Question tempp=(Question) i.next();
            if(tempp.getName().equals(paper.getName()))
            {
                i.remove();
                return true;
            }
        }
        ob.writeValue(user_path.toFile(),personList);
        return false;
    }

    public void cover(List<Question> personList) throws IOException {
        ob.writeValue(user_path.toFile(),personList);
    }

    public void change(Question paper,Question new_p) throws IOException {
        String person_js = Files.readString(user_path);
        List<Question> personList;
        personList=ob.readValue(person_js, new TypeReference<List<Question>>() {});
        if(personList==null||personList.size()==0)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        ListIterator i=personList.listIterator();
        while (i.hasNext())
        {
            Question tempp=(Question) i.next();
            if(tempp.getName().equals(paper.getName()))
            {
                i.remove();
                i.add(new_p);
            }
        }
        ob.writeValue(user_path.toFile(),personList);
    }

    public List<Question> getall() throws IOException {
        String person_js = Files.readString(user_path);
        List<Question> personList;
        if(person_js==null||person_js.length()==0)
        {
            return new ArrayList<>();
        }
        personList=ob.readValue(person_js, new TypeReference<List<Question>>() {});
        return personList;
    }
    public static Questiondao getInstance()
    {
        return userdao;
    }

    public List<Question> get_paper(int[] a) throws IOException {
        String person_js = Files.readString(user_path);
        List<Question> personList;
        List<Question> result_list = new ArrayList<>();
        personList=ob.readValue(person_js, new TypeReference<List<Question>>() {});
        if(personList==null||personList.size()==0)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        ListIterator i=personList.listIterator();
        while (i.hasNext())
        {
            Question tempp=(Question) i.next();
            for (int t=0;t<a.length;t++)
            {
                if(i.nextIndex()==a[t])
                {
                    result_list.add((Question) i.next());
                }
            }
        }
        return result_list;
    }
}
