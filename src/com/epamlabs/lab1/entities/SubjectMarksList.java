package com.epamlabs.lab1.entities;

import java.util.ArrayList;

public class SubjectMarksList{

    private String subjectName;

    private int examMark;

    private ArrayList<Integer> semMarks;


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getExamMark() {
        return examMark;
    }

    public void setExamMark(int examMark) {
        this.examMark = examMark;
    }

    public ArrayList<Integer> getSemMarks() {
        return semMarks;
    }

    public void setSemMarks(ArrayList<Integer> semMarks) {
        this.semMarks = semMarks;
    }
}
