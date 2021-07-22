package com.neu.bike.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.bike.dao.IBikedao;
import com.neu.bike.pojo.impl.Bike;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bikedao implements IBikedao {
    private ObjectMapper ob = new ObjectMapper();
    private Path bike_path = Path.of("/home/tdt/桌面/2021.7实训/共享单车系统/resource/bike.json");
    private static Bikedao bikedao=new Bikedao();
    public boolean add(Bike bike) throws IOException {
        String bike_js = Files.readString(bike_path);
        List<Bike> bikeList =new ArrayList<>();
        if(bike_js==null||bike_js.equals(""))
        {

        }
        else {
            bikeList=ob.readValue(bike_js, new TypeReference<List<Bike>>() {});
        }
        if(bikeList==null)
        {
            IOException e=new IOException("json is null");
            throw e;
        }
        bikeList.add(bike);
        try {
            ob.writeValue(bike_path.toFile(),bikeList);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
        return true;
    };
    public boolean delete(Bike bike) throws IOException {
        String bike_js = Files.readString(bike_path);
        List<Bike> bikeList;
        bikeList=ob.readValue(bike_js, new TypeReference<List<Bike>>() {});
        if(bikeList==null||bikeList.size()==0)
        {
            throw new IOException("json is null");
        }
        Iterator i=bikeList.listIterator();
        while (i.hasNext())
        {
            Bike tempb=(Bike)i.next();
            if(tempb.getId().equals(bike.getId()))
            {
                i.remove();
                return true;
            }
        }
        ob.writeValue(bike_path.toFile(),bikeList);
        return false;
    }
    public static Bikedao getInstance()
    {
        return bikedao;
    }

   public boolean change(Bike bike) throws Exception {
        String bike_js = Files.readString(bike_path);
        List<Bike> bikeList;
        bikeList=ob.readValue(bike_js, new TypeReference<List<Bike>>() {});
        if(bikeList==null||bikeList.size()==0)
        {
            throw new IOException("json is null");
        }
        Iterator i=bikeList.listIterator();
        while (i.hasNext())
        {
            Bike tempb=(Bike)i.next();
            if(tempb.getId().equals(bike.getId()))
            {
                tempb=bike;
                ob.writeValue(bike_path.toFile(),bikeList);
                return true;
            }
        }
        //ob.writeValue(bike_path.toFile(),bikeList);
        return false;
    }

    public Bike search(Bike bike) throws Exception {
        String bike_js = Files.readString(bike_path);
        List<Bike> bikeList;
        bikeList=ob.readValue(bike_js, new TypeReference<List<Bike>>() {});
        if(bikeList==null||bikeList.size()==0)
        {
            throw new IOException("json is null");
        }
        Iterator i=bikeList.listIterator();
        while (i.hasNext())
        {
            Bike tempb=(Bike)i.next();
            if(tempb.getId().equals(bike.getId()))
            {
                return tempb;
            }
        }
        //ob.writeValue(bike_path.toFile(),bikeList);
        return null;
    }
//     //class test
//    public static void main(String[] args) {
//        Bike a=new Bike();
//        a.setId("dfdf");
//        a.setIs_broken(false);
//        a.setIs_taken(true);
//        try {
//            Bikedao.getInstance().delete(a);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
