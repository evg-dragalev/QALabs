package com.edragalev.ta.rzdlogintest.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Page {

    private final Logger logger = LogManager.getRootLogger();

    private final static String START_URL = "http://pass.rzd.ru/esearch/public/ru?STRUCTURE_ID=725";

    @FindBy(xpath = "//span[@class='esearch-highlight'][1]")
    private WebElement highlightedText;

    @FindBy(xpath = "//*[@id=\"container\"]/tbody/tr/td[2]/table/tbody/tr/td[1]/div/form/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"container\"]/tbody/tr/td[2]/table/tbody/tr/td[1]/div/form/table/tbody/tr[4]/td[2]/button")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[@class='j-search_container']//div[1]")
    private WebElement firstResultDiv;

    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getFirstResultDivText(){
        return firstResultDiv.getAttribute("innerText");
    }

    public String getHighlightedText(){
        return highlightedText.getText();
    }

    public void fillSearchInput(String keyphrase){
        searchInput.sendKeys(keyphrase);
    }

    public void search(){
        buttonSearch.click();
    }

    @Override
    public void open() {
        driver.navigate().to(START_URL);
        logger.info("Search start page opened");
    }
}
