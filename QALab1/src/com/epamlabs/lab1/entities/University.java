package com.epamlabs.lab1.entities;

import java.util.ArrayList;

public class University implements Unit{

    private String name;

    private ArrayList<Faculty> faculties;


    public University(String name, ArrayList<Faculty> faculties){
        this.name = name;
        this.faculties = faculties;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "University: "+ name;
    }
}
