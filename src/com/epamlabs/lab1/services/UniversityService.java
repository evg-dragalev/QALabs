package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.Faculty;
import com.epamlabs.lab1.entities.University;

import java.util.ArrayList;

public class UniversityService extends UnitMarkService {

    private University university;

    private FacultyService facultyService;


    public UniversityService(FacultyService facultyService){
        this.facultyService = facultyService;
    }


    public void setUniversity(University university) {
        this.university = university;
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