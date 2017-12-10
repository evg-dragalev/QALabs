package com.edragalev.ta.rzdlogintest.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static WebDriver driver;

    private static final Logger logger = LogManager.getRootLogger();

    private final static String CHROME_DRIVER = "webdriver.chrome.driver";

    private final static String CHROME_DRIVER_PATH = "chromedriver"+File.separator+"chromedriver";

    public static WebDriver getDriver(){

        if(driver == null){
            System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            logger.info("LoginSteps started");
        }

        return driver;
    }

    public static void closeDriver(){
        driver.close();
        driver = null;
    }
}
