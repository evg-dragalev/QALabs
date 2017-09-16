package com.epamlabs.lab1;

import com.epamlabs.lab1.services.AppService;
import com.epamlabs.lab1.services.UnitReaderService;

public class Run {

    private static AppService initialize(){
        UnitReaderService readerService = new UnitReaderService();
        return new AppService(readerService.getData());
    }

    public static void main(String[] args) {
        AppService appService = Run.initialize();
        appService.run();

    }
}
