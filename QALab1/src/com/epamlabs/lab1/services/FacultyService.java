package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.Faculty;
import com.epamlabs.lab1.entities.Group;

import java.util.ArrayList;

public class FacultyService extends UnitService {

    private Faculty faculty;

    private GroupService groupService;

    public FacultyService(){
        this.groupService = new GroupService();
    }


    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String getUnitInfo() {
        return this.faculty.toString();
    }

    @Override
    public ArrayList<Group> getSubUnitList() {
        return this.faculty.getGroups();
    }

    @Override
    public UnitService getSubUnitService(int groupIndex){
        groupService.setGroup(getSubUnitList().get(groupIndex));
        return this.groupService;
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
