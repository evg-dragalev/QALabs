package com.epamlabs.lab1.entities;

import java.util.ArrayList;

public class Student implements Unit{
    private String name;

    private ArrayList<SubjectMarks> subjects;


    public Student(String name, ArrayList<SubjectMarks> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<SubjectMarks> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<SubjectMarks> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student: " + name + " ";
    }
}
