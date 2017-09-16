package com.epamlabs.lab1.entities;

import java.util.ArrayList;

public class Group implements Unit{

    private int course;

    private String number;

    private ArrayList<Student> students;


    public Group(int course, String number, ArrayList<Student> students) {
        this.course = course;
        this.number = number;
        this.students = students;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if( course >= 1 && course <= 5) {
            this.course = course;
        } else {
            throw new IllegalArgumentException("Course should be >=1 and <=5");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Group " + number + ", course: " + this.course;
    }
}
