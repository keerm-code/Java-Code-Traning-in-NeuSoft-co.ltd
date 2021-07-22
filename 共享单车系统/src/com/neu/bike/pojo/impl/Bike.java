package com.neu.bike.pojo.impl;

import com.fasterxml.jackson.annotation.*;
import com.neu.bike.pojo.IBike;

public class Bike implements IBike {
    private String id;
    private boolean is_broken;
    private boolean is_taken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIs_broken() {
        return is_broken;
    }

    public void setIs_broken(boolean is_broken) {
        this.is_broken = is_broken;
    }

    public boolean isIs_taken() {
        return is_taken;
    }

    public void setIs_taken(boolean is_taken) {
        this.is_taken = is_taken;
    }
}
