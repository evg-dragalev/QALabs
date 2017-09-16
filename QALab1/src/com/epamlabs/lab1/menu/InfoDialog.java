package com.epamlabs.lab1.menu;

import com.epamlabs.lab1.services.UnitService;

public class InfoDialog extends Dialog {

    public InfoDialog(UnitService unitService, Dialog prevDialog){
        super(unitService, prevDialog);
    }

    @Override
    public Dialog handleInput(int menuItem) {
        if(menuItem == 0){
            return super.exit();
        }
        if(menuItem == 1){
            return super.back();
        }
        throw new IllegalArgumentException("Unresolved symbol");
    }

    @Override
    public String getDialogContent() {
        return this.prevDialog.getInfo() +
                "Average score: " + this.unitService.obtainAverage() +
                "\n0. Exit\n" +
                "1. Back\n";
    }
}
