package com.edragalev.ta.rzdlogintest.steps;

import com.edragalev.ta.rzdlogintest.driver.DriverSingleton;
import com.edragalev.ta.rzdlogintest.page.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
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

    public LoginPage login(String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.login(username, password);

        return loginPage;
    }
}
