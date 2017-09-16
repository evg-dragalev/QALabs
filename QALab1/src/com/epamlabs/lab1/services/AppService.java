package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.App;
import com.epamlabs.lab1.entities.University;
import com.epamlabs.lab1.menu.Dialog;

import java.util.ArrayList;
import java.util.Scanner;

public class AppService extends UnitService{

    private Dialog dialog;

    private App app;

    private UniversityService universityService;


    public AppService(App app){
        this.app = app;
        this.universityService = new UniversityService();
    }

    public void run(){
        this.dialog = new Dialog(this);
        Scanner cin = new Scanner(System.in);
        while(this.dialog != null) {
            dialog.display();
            try {
                this.dialog = dialog.handleInput(cin.nextInt());
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public String getUnitInfo() {
        return "=====Average score calculator=====";
    }

    @Override
    public ArrayList<Double> getMarks() {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public ArrayList<University> getSubUnitList() {
        return app.getUniversities();
    }

    @Override
    public UnitService getSubUnitService(int universityIndex) {
        this.universityService.setUniversity(app.getUniversities().get(universityIndex));
        return this.universityService;
    }
}
