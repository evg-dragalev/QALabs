package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.Unit;

import java.util.ArrayList;

public abstract class UnitService {

    public abstract String getUnitInfo();

    public abstract ArrayList<?extends Unit> getSubUnitList();

    public abstract UnitService getSubUnitService(int nextUnitIndex);

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
