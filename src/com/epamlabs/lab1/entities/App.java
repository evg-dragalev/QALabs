package com.epamlabs.lab1.entities;

import java.util.ArrayList;

public class App implements Unit {
    private ArrayList<University> universities;

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public void setUniversities(ArrayList<University> universities) {
        this.universities = universities;
    }
}
