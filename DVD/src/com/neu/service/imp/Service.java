package com.neu.service.imp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.fasterxml.jackson.core.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.neu.dao.imp.Cddao;
import com.neu.pojo.imp.Cd;
import com.neu.pojo.imp.Note;
import com.neu.pojo.imp.Notes;
import com.neu.service.IService;

public class Service implements IService {
    // 对象集合实例化
    Cddao dao = new Cddao();
    // 使用java11风格读取文件
    Path notename = Path.of("/home/tdt/桌面/2021.7实训/DVD/src/com/neu/resource/note.json");
    Path filename = Path.of("/home/tdt/桌面/2021.7实训/DVD/src/com/neu/resource/resource.json");
    Notes notes = new Notes();
    //JSON.
    @Override
    public void init() throws IOException {
        // java11 fileread
        String jstring = Files.readString(filename);
        String jsnote = Files.readString(notename);
        // JSONArray jsarray=JSON.parseArray(jstring);
        List<Cd> jscds = JSON.parseArray(jstring, Cd.class);
        List<Note> jsnotes = JSON.parseArray(jsnote, Note.class);
        if(jscds==null||jsnotes==null)//不能equals判定
        {
            IOException e=new IOException("json文件为空");
            throw e;
        }
        for (Cd cd : jscds) {
            dao.add_cd(cd);
        }
        for (Note s : jsnotes) {
            notes.add_notes(s.toString());
        }
        System.out.print("");
    }

    @Override
    public void add(Cd cd) {
        this.dao.add_cd(cd);
    }

    @Override
    public boolean delete(Cd cd) {
        return this.dao.delete_cd(cd);
    }

    @Override
    public int add_cost(Cd cd, int return_date) {
        
        return this.dao.add_cost(cd, return_date);
    }

    @Override
    public boolean lend_cd(Cd cd, int date) {
        
        if (dao.find_cd(cd.get_name())!=null){
            for (Cd tempcd : dao.get_all_cds()) {
                if (tempcd.get_name().equals(cd.get_name()) && !tempcd.get_islend()) {
                    tempcd.set_islend(true);
                    tempcd.set_lenddate(date);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean return_cd(Cd cd, int date) {
        
        if (!this.dao.find_cd(cd.get_name()).equals(null)) {
            for (Cd tempcd : dao.get_all_cds()) {
                if (tempcd.get_name().equals(cd.get_name()) && !tempcd.get_islend()) {
                    tempcd.set_islend(false);
                    tempcd.set_lenddate(0);
                    tempcd.set_cost(0);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void save_data() throws IOException {
        //保存文件
        String jstring = JSON.toJSONString(dao.get_all_cds(),SerializerFeature.PrettyFormat);
        String jsnote = JSON.toJSONString(notes.get_notes());
        Files.writeString(filename, jstring, StandardOpenOption.APPEND);
        Files.writeString(notename, jsnote, StandardOpenOption.APPEND);
    }

    @Override
    public String show_all_cds() {
        
        String out="";
        for (Cd cd : dao.get_all_cds()) {
            out=out+cd.toString();
        }
        return out;
    }

}
