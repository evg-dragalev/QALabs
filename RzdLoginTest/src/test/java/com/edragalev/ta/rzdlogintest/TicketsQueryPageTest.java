package com.edragalev.ta.rzdlogintest;

import com.edragalev.ta.rzdlogintest.page.TicketsQueryPage;
import com.edragalev.ta.rzdlogintest.steps.TicketsQuerySteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TicketsQueryPageTest {

    private Logger logger = LogManager.getRootLogger();

    private TicketsQuerySteps steps;

    private final static String CORRECT_STATION_FROM = "МИНСК-ПАССАЖИРСКИЙ";

    private final static String CORRECT_STATION_TO = "ГОМЕЛЬ-ПАССАЖИРСКИЙ";

    private final static String INCORRECT_STATION_TO = "AZEROTH";

    @BeforeMethod(description = "Init steps")
    public void setUp(){
        steps = new TicketsQuerySteps();
        steps.init();
    }

    @Test
    public void getTimetableForCorrectStations(){
        String expected = String.format("%s — %s", CORRECT_STATION_FROM, CORRECT_STATION_TO);

        TicketsQueryPage page = steps.openTicketsQueryPage();
        steps.queryTickets(CORRECT_STATION_FROM, CORRECT_STATION_TO, page);

        String actual = page.getStationsInfo();
        logger.info(String.format("actual: %s\nexpected: %s", actual.toUpperCase(), expected ));
        Assert.assertEquals(actual.toUpperCase(), expected);
    }

    @Test
    public void timetableButtonDisabledWhenIncorrectStations(){

        TicketsQueryPage page = steps.openTicketsQueryPage();
        steps.fillFields(CORRECT_STATION_FROM, INCORRECT_STATION_TO, page);

        boolean actual = page.isTimetableButtonEnabled();

        Assert.assertFalse(actual);
    }

    @Test
    public void oneCanSwapStations(){
        String expected = String.format("%s — %s", CORRECT_STATION_TO, CORRECT_STATION_FROM);

        TicketsQueryPage page = steps.openTicketsQueryPage();
        steps.queryTickets(CORRECT_STATION_FROM, CORRECT_STATION_TO, page);
        steps.swapStations(page);

        String actual = page.getStationsInfo();

        Assert.assertEquals(actual.toUpperCase(), expected);

    }

    @AfterMethod(description = "Stop steps")
    public void stopBrowser(){
        steps.close();
    }

}
