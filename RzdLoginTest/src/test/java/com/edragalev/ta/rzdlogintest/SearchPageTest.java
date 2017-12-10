package com.edragalev.ta.rzdlogintest;

import com.edragalev.ta.rzdlogintest.page.SearchPage;
import com.edragalev.ta.rzdlogintest.steps.SearchPageSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchPageTest {

    private Logger logger = LogManager.getRootLogger();

    private SearchPageSteps steps;

    private final static String KEYWORD = "Минск";

    private final static String WRONG_KEYWORD = "AZEROTH";

    private final static String NO_RESULT_STRING = "По вашему запросу ничего не найдено";

    @BeforeTest(description = "Init steps")
    public void setUp(){
        steps = new SearchPageSteps();
        steps.init();
    }

    @Test
    public void pageHighlightCorrectWords(){
        String expected = KEYWORD;

        SearchPage page = steps.openSearchPage();
        steps.searchPhrase(KEYWORD, page);

        String actual = page.getHighlightedText();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void NoResultCaseNotification(){
        SearchPage page = steps.openSearchPage();
        steps.searchPhrase(WRONG_KEYWORD, page);

        String actual = page.getFirstResultDivText();
        String expected = NO_RESULT_STRING;

        Assert.assertEquals(actual, expected);
    }

    @AfterTest(description = "Stop steps")
    public void stopBrowser(){
        steps.close();
    }
}
