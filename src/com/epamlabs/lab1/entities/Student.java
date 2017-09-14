package com.epamlabs.lab1.entities;

import java.util.ArrayList;

public class Student{
    private String firstName;

    private String lastName;

    private ArrayList<SubjectMarks> subjects;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<SubjectMarks> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<SubjectMarks> subjects) {
        this.subjects = subjects;
    }
}
