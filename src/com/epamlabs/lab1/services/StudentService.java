package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.Student;
import com.epamlabs.lab1.entities.SubjectMarks;

import java.util.ArrayList;

public class StudentService extends UnitService {

    private Student student;

    private SubjectService subjectService;


    public StudentService(){
        this.subjectService = new SubjectService();
    }


    private ArrayList<Double> getExamMarks(){
        ArrayList<Double> marks = new ArrayList<>();
        for (SubjectMarks subject : student.getSubjects()){
            int mark = subject.getExamMark();
            marks.add(((mark!=-1)? mark : 0)+.0);
        }
        return marks;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String getUnitInfo() {
        return this.student.toString();
    }

    @Override
    public ArrayList<SubjectMarks> getSubUnitList() {
        return this.student.getSubjects();
    }

    @Override
    public UnitService getSubUnitService(int subjectIndex) {
        this.subjectService.setSubject(getSubUnitList().get(subjectIndex));
        return this.subjectService;
    }

    @Override
    public ArrayList<Double> getMarks() {
        return this.getExamMarks();
    }
}
