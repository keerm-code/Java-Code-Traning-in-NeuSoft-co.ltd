package com.neu.pojo.imp;

import java.util.ArrayList;
import java.util. List;

public class Notes {
    private  List<Note> notes=new  ArrayList<>();



    public void add_notes(String note)
    {
        Note a=new Note(note);
        notes.add(a);
    }
    public  List<Note> get_notes()
    {
        return this.notes;
    }
}
