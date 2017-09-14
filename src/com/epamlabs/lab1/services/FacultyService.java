package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.Faculty;
import com.epamlabs.lab1.entities.Group;

import java.util.ArrayList;

public class FacultyService extends UnitMarkService {

    private Faculty faculty;

    private GroupService groupService;

    public FacultyService(GroupService groupService){
        this.groupService = groupService;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public ArrayList<Double> getMarks() {
        ArrayList<Double> marks = new ArrayList<>();
        for(Group group : faculty.getGroups()){
            groupService.setGroup(group);
            marks.add(groupService.obtainAverage());
        }
        return marks;
    }
}
