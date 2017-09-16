package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.SubjectMarks;
import com.epamlabs.lab1.entities.Unit;

import java.util.ArrayList;

public class SubjectService extends UnitService {

    private SubjectMarks subject;


    private ArrayList<Double> getSemMarks(){
        ArrayList<Double> marks = new ArrayList<>();
        for( Integer mark : subject.getSemMarks()){
            marks.add(mark +.0);
        }
        return marks;
    }

    public void setSubject(SubjectMarks subject) {
        this.subject = subject;
    }

    @Override
    public String getUnitInfo() {
        return this.subject.toString();
    }

    @Deprecated
    @Override
    public ArrayList<?extends Unit> getSubUnitList() {
       return new ArrayList<>();
    }

    @Deprecated
    @Override
    public UnitService getSubUnitService(int unitIndex) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public ArrayList<Double> getMarks() {
        return this.getSemMarks();
    }
}
