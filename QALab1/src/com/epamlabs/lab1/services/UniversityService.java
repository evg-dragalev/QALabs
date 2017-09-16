package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.Faculty;
import com.epamlabs.lab1.entities.University;

import java.util.ArrayList;

public class UniversityService extends UnitService {

    private University university;

    private FacultyService facultyService;


    public UniversityService(){
        this.facultyService = new FacultyService();
    }


    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String getUnitInfo() {
        return this.university.toString();
    }

    @Override
    public ArrayList<Faculty> getSubUnitList(){
        return this.university.getFaculties();
    }

    @Override
    public UnitService getSubUnitService(int facultyIndex) {
        this.facultyService.setFaculty(getSubUnitList().get(facultyIndex));
        return this.facultyService;
    }

    @Override
    public ArrayList<Double> getMarks() {
        ArrayList<Double> marks = new ArrayList<>();
        for(Faculty faculty : university.getFaculties()){
            facultyService.setFaculty(faculty);
            marks.add(facultyService.obtainAverage());
        }
        return marks;
    }
}