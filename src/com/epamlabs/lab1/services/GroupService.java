package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.Group;
import com.epamlabs.lab1.entities.Student;

import java.util.ArrayList;

public class GroupService extends UnitMarkService {

    private Group group;

    private StudentService studentService;

    public GroupService(StudentService studentService){
        this.studentService = studentService;
    }


    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public ArrayList<Double> getMarks() {
        ArrayList<Double> marks = new ArrayList<>();
        for(Student student : group.getStudents()){
            studentService.setStudent(student);
            marks.add(studentService.obtainAverage());
        }
        return marks;
    }
}
