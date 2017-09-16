package com.epamlabs.lab1.menu;

import com.epamlabs.lab1.entities.Unit;
import com.epamlabs.lab1.services.AppService;
import com.epamlabs.lab1.services.UnitService;


public class Dialog {
    UnitService unitService;

    Dialog prevDialog;

    public Dialog(AppService appService){
        this.unitService = appService;
    }

    Dialog(UnitService unitService, Dialog prevDialog){
        this.unitService = unitService;
        this.prevDialog = prevDialog;
    }

    String getInfo(){
        StringBuilder fullInfo = new StringBuilder();
        if(prevDialog != null){
            fullInfo.append(this.prevDialog.getInfo());
        }
        fullInfo.append(this.unitService.getUnitInfo()).append("\n");
        return fullInfo.toString();
    }

    protected String getDialogContent(){
        StringBuilder unitMenu = new StringBuilder(getInfo());
        unitMenu.append("0. Exit\n");
        int picker = 1;
        for(Unit unit : unitService.getSubUnitList()) {
            unitMenu.append(picker).append(". ").append(unit.toString()).append("\n");
            picker++;
        }
        if(prevDialog != null) {
            unitMenu.append(picker).append(". Back\n")
                    .append(picker + 1).append(". Calculate average\n");
        }
        return unitMenu.toString();
    }

    public void display(){
        System.out.print(
                getDialogContent() +
                "Go to: "
        );
    }

    public Dialog handleInput(int menuItem) {
        int unitsAmount = unitService.getSubUnitList().size();
        if (menuItem == 0) {
            return exit();
        }
        if (menuItem >= 1 && menuItem <= unitsAmount) {
            return goTo(menuItem - 1);
        }
        if (prevDialog != null) {
            if (menuItem == unitsAmount + 1) {
                return back();
            }
            if (menuItem == unitsAmount + 2){
                return displayAverage();
            }
        }
        throw new IllegalArgumentException("Unresolved symbol");
    }

    protected Dialog exit(){
        return null;
    }

    protected Dialog back(){
        return this.prevDialog;
    }

    private Dialog displayAverage(){
        return new InfoDialog(this.unitService, this);
    }

    private Dialog goTo(int unitIndex){
        return new Dialog(unitService.getSubUnitService(unitIndex), this);
    }
}
