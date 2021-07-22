package com.neu.test.pojo.impl;

import com.neu.test.pojo.IQuestion;

public class Question implements IQuestion {//implements interface IQuestion

    public boolean isIs_select() {
        return is_select;
    }

    public void setIs_select(boolean is_select) {
        this.is_select = is_select;
    }

    boolean is_select;
    String name;//Question's name
    String answer1;//5
    String answer2;//3
    String answer3;//1

    public String getName() {//auto set and get
        return name;
    }

    public void setName(String name) {//auto set and get
        this.name = name;
    }

    public String getAnswer1() {//auto set and get
        return answer1;
    }

    public void setAnswer1(String answer1) {//auto set and get
        this.answer1 = answer1;
    }

    public String getAnswer2() {//auto set and get
        return answer2;
    }

    public void setAnswer2(String answer2) {//auto set and get
        this.answer2 = answer2;
    }

    public String getAnswer3() {//auto set and get
        return answer3;
    }

    public void setAnswer3(String answer3) {//auto set and get
        this.answer3 = answer3;
    }

    public Question(String name, String answer1, String answer2, String answer3) {////auto constructor
        this.name = name;//use "this" to avoid distinguish
        this.answer1 = answer1;//use "this" to avoid distinguish
        this.answer2 = answer2;//use "this" to avoid distinguish
        this.answer3 = answer3;//use "this" to avoid distinguish
        this.is_select=false;
    }

    public Question() {//auto constructor,need by json
    }


}
