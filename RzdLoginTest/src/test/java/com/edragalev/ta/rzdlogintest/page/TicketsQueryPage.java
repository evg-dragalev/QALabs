package com.edragalev.ta.rzdlogintest.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketsQueryPage extends Page {

    private final Logger logger = LogManager.getRootLogger();

    private final static String URL = "http://pass.rzd.ru/";

    @FindBy(id = "Submit")
    private WebElement buttonBuyTicket;

    @FindBy(id = "Submit1")
    private WebElement buttonTimetable;

    @FindBy(id = "name0")
    private WebElement fromInput;

    @FindBy(id = "name1")
    private WebElement toInput;

    @FindBy(xpath = "//button[text()='Изменить запрос']" )
    private WebElement buttonChange;

    @FindBy(className = "form-search__stations")
    private WebElement stationsInfo;

    @FindBy(xpath = "//*[@id=\"Page0\"]/div/div[1]/div[1]/div[1]/form/div[1]/div[1]/div[2]/div")
    private WebElement buttonSwap;

    @FindBy(xpath = "//input[@value='Подобрать']")
    private WebElement buttonPick;

    public TicketsQueryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getStationsInfo(){
        logger.info(String.format("text: %s", stationsInfo.getAttribute("innerText")));
        return stationsInfo.getAttribute("innerText");
    }

    public void fillFromField(String from){
        fromInput.sendKeys(from);
    }

    public void fillToField(String to){
        toInput.sendKeys(to);
    }

    public void pickTrain(){
        buttonPick.click();
    }

    public void buyTicket(){
        buttonBuyTicket.click();
        logger.info("Button \"Купить билет\" clicked");
    }

    public boolean isTimetableButtonEnabled(){
        return buttonTimetable.isEnabled();
    }

    public void swapStations(){
        buttonSwap.click();
    }

    public void dropChangeRouteForm(){
        buttonChange.click();
    }

    @Override
    public void open() {
        driver.navigate().to(URL);
        logger.info("TicketsQuery page opened");
    }
}
