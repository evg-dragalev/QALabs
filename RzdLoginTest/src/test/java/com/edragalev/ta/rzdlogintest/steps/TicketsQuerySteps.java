package com.edragalev.ta.rzdlogintest.steps;

import com.edragalev.ta.rzdlogintest.driver.DriverSingleton;
import com.edragalev.ta.rzdlogintest.page.TicketsQueryPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TicketsQuerySteps {

    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void init(){
        driver = DriverSingleton.getDriver();
    }

    public void close(){
        DriverSingleton.closeDriver();
    }

    public TicketsQueryPage openTicketsQueryPage(){
        TicketsQueryPage ticketsQueryPage = new TicketsQueryPage(driver);
        ticketsQueryPage.open();
        return ticketsQueryPage;
    }

    public void fillFields(String from, String to, TicketsQueryPage page){
        page.fillFromField(from);
        page.fillToField(to);
    }

    public void queryTickets(String from, String to, TicketsQueryPage page){
        fillFields(from, to, page);
        page.buyTicket();
    }

    public void swapStations(TicketsQueryPage page){
        page.dropChangeRouteForm();
        page.swapStations();
        page.pickTrain();
        logger.info(String.format("Stations swapped to: %s", page.getStationsInfo()));
    }

}
