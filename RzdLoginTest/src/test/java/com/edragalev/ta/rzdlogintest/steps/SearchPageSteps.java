package com.edragalev.ta.rzdlogintest.steps;

import com.edragalev.ta.rzdlogintest.driver.DriverSingleton;
import com.edragalev.ta.rzdlogintest.page.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SearchPageSteps {

    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void init(){
        driver = DriverSingleton.getDriver();
    }

    public void close(){
        DriverSingleton.closeDriver();
    }

    public SearchPage openSearchPage(){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.open();
        return searchPage;
    }

    public void searchPhrase(String phrase, SearchPage page){
        page.fillSearchInput(phrase);
        page.search();
    }
}
