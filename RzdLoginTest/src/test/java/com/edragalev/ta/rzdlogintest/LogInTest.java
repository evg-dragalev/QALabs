package com.edragalev.ta.rzdlogintest;

import com.edragalev.ta.rzdlogintest.browser.Browser;
import com.edragalev.ta.rzdlogintest.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest {

    private Browser browser;

    private final static String USERNAME = "BookWyrm";

    private final static String INCORRECT_PASSWORD = "IAmPowerIncarnate";

    private final static String CORRECT_PASSWORD = "LetReadingDragonsLie";

    private final static String NAME = "Антон Маликов";

    private final static String ERROR_MESSAGE = "Ошибка: Неверное имя пользователя или пароль";

    @BeforeMethod(description = "Init browser")
    public void setUp(){
        browser = new Browser();
        browser.init();
    }

    @Test
    public void incorrectUsernameOrPasswordMessage(){
        LoginPage loginPage = new LoginPage(browser.getDriver());
        loginPage.open();
        loginPage.login(USERNAME, INCORRECT_PASSWORD);

        boolean condition = loginPage.getErrorMessage().equals(ERROR_MESSAGE);

        Assert.assertTrue(condition);
    }

    @Test(description = "Login to rzd")
    public void oneCanLoginRzt(){
        LoginPage loginPage = new LoginPage(browser.getDriver());
        loginPage.open();
        loginPage.login(USERNAME, CORRECT_PASSWORD);

        boolean condition = loginPage.getUsername().equals(NAME);

        Assert.assertTrue(condition);
    }


    @AfterMethod(description = "Stop browser")
    public void stopBrowser(){
        browser.close();
    }

}
