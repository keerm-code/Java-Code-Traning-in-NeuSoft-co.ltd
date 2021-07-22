package com.neu.test.pojo.impl;

import com.neu.test.pojo.IPaper;

import java.util.Arrays;
import java.util.List;

public class Paper implements IPaper {//implements interface IPaper
    String id;//qustion id

    public Paper(String id, List<Question> questions) {
        this.id = id;
        this.questions = questions;
        this.is_select=false;
    }

    public boolean isIs_select() {
        return is_select;
    }

    public void setIs_select(boolean is_select) {
        this.is_select = is_select;
    }

    private  boolean is_select;
    private List<Question> questions;//questions` nums

    public Paper(){};// auto constructor

    public String getId() {
        return id;
    }//auto get and set

    public void setId(String id) {
        this.id = id;
    }//auto get and set


    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
