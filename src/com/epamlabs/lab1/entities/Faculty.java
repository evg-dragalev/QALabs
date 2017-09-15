package com.epamlabs.lab1.entities;

import java.util.ArrayList;

public class Faculty implements Unit{

    private String name;

    private ArrayList<Group> groups;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Faculty: "+ name;
    }
}
