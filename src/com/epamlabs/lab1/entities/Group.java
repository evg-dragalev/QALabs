package com.epamlabs.lab1.entities;

import java.util.List;

public class Group {

    private int course;

    private String number;

    private String speciality;

    private List<Student> students;


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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String name) {
        this.speciality = name;
    }

    public List<Student> getStudents() {
        return students;
    }
}
