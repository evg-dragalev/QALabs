package com.epamlabs.lab1.services;

import java.util.ArrayList;

public abstract class UnitMarkService {

    public abstract ArrayList<Double> getMarks();

    public final double obtainAverage() {
        ArrayList<Double> markList = this.getMarks();
        markList.trimToSize();
        double sum = 0;
        for (double mark : markList) {
            sum += mark;
        }
        return sum / markList.size();
    }

}
