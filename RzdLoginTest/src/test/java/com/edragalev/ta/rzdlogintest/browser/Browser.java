package com.edragalev.ta.rzdlogintest.browser;

import com.edragalev.ta.rzdlogintest.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Browser {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void init(){
        driver = DriverSingleton.getDriver();
    }

    public void close(){
        DriverSingleton.closeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
