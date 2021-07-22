package com.neu.test.service.impl;

import com.neu.test.dao.impl.Empdao;
import com.neu.test.dao.impl.Paperdao;
import com.neu.test.dao.impl.Questiondao;
import com.neu.test.dao.impl.Userdao;
import com.neu.test.pojo.impl.Employee;
import com.neu.test.pojo.impl.Paper;
import com.neu.test.pojo.impl.Question;
import com.neu.test.pojo.impl.User;
import com.neu.test.service.IService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Service implements IService {
    private Service() {

    }
    private static Service service=new Service();
    public static Service getInstance()
    {
        return service;
    }
    public Employee login(Employee em) throws IOException {
        if(Empdao.getInstance().find(em)!=null)
        {
            System.out.println(Empdao.getInstance().find(em));
            return Empdao.getInstance().find(em);
        }
        else return null;
    }
    public boolean signin(Employee em)
    {
        try {
            if(Empdao.getInstance().find(em)==null)
            {
                Empdao.getInstance().add(em);
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Employee> get_all_emp() throws IOException {
        return Empdao.getInstance().getall();
    }
    public void cover_empdao(List<Employee> a)
    {
        try {
            Empdao.getInstance().cover(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Employee> low_find(String str) throws IOException {
        ListIterator i=Empdao.getInstance().getall().listIterator();
        List<Employee> a=new ArrayList<>();
        while (i.hasNext())
        {
            Employee tempem=(Employee) i.next();
            if(tempem.toString().contains(str))
            {
                a.add(tempem);
            }
        }
        return a;
    }

    public List<User> low_find_usr(String str) throws IOException {
        ListIterator i=Userdao.getInstance().getall().listIterator();
        List<User> a=new ArrayList<>();
        while (i.hasNext())
        {
            User tempem=(User) i.next();
            if(tempem.toString().contains(str))
            {
                a.add(tempem);
            }
        }
        return a;
    }

    public List<User> get_all_usr()
    {
        try {
            return Userdao.getInstance().getall();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void cover_user(List<User> p)
    {
        try {
            Userdao.getInstance().cover(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Question> get_all_qust() throws IOException {
        return Questiondao.getInstance().getall();
    }

    public void cover_questions(List<Question> questions)
    {
        try {
            Questiondao.getInstance().cover(questions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Question> low_find_qust(String str) throws IOException {
        ListIterator i=Questiondao.getInstance().getall().listIterator();
        List<Question> a=new ArrayList<>();
        while (i.hasNext())
        {
            Question tempem=(Question) i.next();
            if(tempem.toString().contains(str))
            {
                a.add(tempem);
            }
        }
        return a;
    }
    public List<Paper> get_all_paper()
    {
        try {
            return Paperdao.getInstance().getall();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void cover_papers(List<Paper> lp)
    {
        try {
            Paperdao.getInstance().cover(lp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Paper> low_find_paper(String str) throws IOException {
        ListIterator i=Questiondao.getInstance().getall().listIterator();
        List<Paper> a=new ArrayList<>();
        while (i.hasNext())
        {
            Paper tempem=(Paper) i.next();
            if(tempem.toString().contains(str))
            {
                a.add(tempem);
            }
        }
        return a;
    }
    public void add_paper(Paper p)
    {
        try {
            Paperdao.getInstance().add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
