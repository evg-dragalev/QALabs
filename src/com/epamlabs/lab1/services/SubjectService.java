package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.SubjectMarks;

import java.util.ArrayList;

public class SubjectService extends UnitMarkService {

    private SubjectMarks subject;

    public void setSubject(SubjectMarks subject) {
        this.subject = subject;
    }

    private ArrayList<Double> getSemMarks(){
        ArrayList<Double> marks = new ArrayList<>();
        for( Integer mark : subject.getSemMarks()){
            marks.add(mark+.0);
        }
        return marks;
    }

    @Override
    public ArrayList<Double> getMarks() {
        return this.getSemMarks();
    }
}
