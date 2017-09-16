package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.Group;
import com.epamlabs.lab1.entities.Student;

import java.util.ArrayList;

public class GroupService extends UnitService {

    private Group group;

    private StudentService studentService;

    public GroupService(){
        this.studentService = new StudentService();
    }


    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String getUnitInfo() {
        return this.group.toString();
    }

    @Override
    public ArrayList<Student> getSubUnitList() {
        return this.group.getStudents();
    }

    @Override
    public UnitService getSubUnitService(int studentIndex) {
        this.studentService.setStudent(getSubUnitList().get(studentIndex));
        return this.studentService;
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
