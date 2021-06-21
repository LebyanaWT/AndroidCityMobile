package com.mobile.citymanagementapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Mall implements Serializable {

    private int id;
    private String name;
    private Shop[] shops;

    public Mall() {
    }

    public Mall(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop[] getShops() {
        return shops;
    }

    public void setShops(Shop[] shops) {
        this.shops = shops;
    }
}
