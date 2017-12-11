package com.edragalev.ta.rzdlogintest.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    private final Logger logger = LogManager.getRootLogger();

    private final String URL = "https://rzd.ru/timetable/logon/ru";

    @FindBy(id = "j_username")
    private WebElement inputLogin;

    @FindBy(id = "j_password")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@value='Вход']")
    private WebElement buttonSubmit;

    @FindBy(className = "j-profile-username")
    private WebElement linkLoggedInUser;

    @FindBy(xpath = "//*[@id='container']/tbody/tr/td/div[2]/b")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void open()    {
        driver.navigate().to(URL);
        logger.info("Login page opened");
    }

    public void login(String username, String password)    {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        logger.info("Login performed");
    }

    public String getUsername()    {
        return linkLoggedInUser.getText();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
