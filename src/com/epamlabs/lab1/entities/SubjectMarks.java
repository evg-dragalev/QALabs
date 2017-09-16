package com.epamlabs.lab1.entities;

import java.util.ArrayList;

public class SubjectMarks implements Unit{

    private String subjectName;

    private int examMark;

    private ArrayList<Integer> semMarks;


    public SubjectMarks(String subjectName, int examMark, ArrayList<Integer> semMarks) {
        this.subjectName = subjectName;
        this.semMarks = semMarks;
        this.examMark = examMark;
    }

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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(this.subjectName).append(" :");
        for(int mark: this.semMarks){
            res.append(" ").append(mark);
        }
        res.append(", exam: ").append((this.examMark==-1)?"none":this.examMark);
        return res.toString();
    }
}
