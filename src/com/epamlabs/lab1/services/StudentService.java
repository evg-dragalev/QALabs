package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.Student;
import com.epamlabs.lab1.entities.SubjectMarks;

import java.util.ArrayList;

public class StudentService extends UnitMarkService {

    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    private ArrayList<Double> getExamMarks(){
        ArrayList<Double> marks = new ArrayList<>();
        for (SubjectMarks subject : student.getSubjects()){
            marks.add(subject.getExamMark()+.0);
        }
        return marks;
    }

    @Override
    public ArrayList<Double> getMarks() {
        return this.getExamMarks();
    }
}
