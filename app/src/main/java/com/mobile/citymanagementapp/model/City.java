package com.mobile.citymanagementapp.model;

import java.util.Arrays;

public class City {


    private int id;
    private String name;
    private Mall[] malls;

    public City() {
    }

    public City(int id, String name) {
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

    public Mall[] getMalls() {
        return malls;
    }

    public void setMalls(Mall[] malls) {
        this.malls = malls;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", malls=" + Arrays.toString(malls) +
                '}';
    }
}
