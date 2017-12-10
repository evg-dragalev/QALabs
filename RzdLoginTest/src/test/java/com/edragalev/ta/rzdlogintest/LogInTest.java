package com.edragalev.ta.rzdlogintest;

import com.edragalev.ta.rzdlogintest.steps.LoginSteps;
import com.edragalev.ta.rzdlogintest.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest {

    private LoginSteps steps;

    private final static String USERNAME = "BookWyrm";

    private final static String INCORRECT_PASSWORD = "IAmPowerIncarnate";

    private final static String CORRECT_PASSWORD = "LetReadingDragonsLie";

    private final static String NAME = "Антон Маликов";

    private final static String ERROR_MESSAGE = "Ошибка: Неверное имя пользователя или пароль";

    @BeforeMethod(description = "Init steps")
    public void setUp(){
        steps = new LoginSteps();
        steps.init();
    }

    @Test
    public void incorrectUsernameOrPasswordMessage(){
        LoginPage loginPage = new LoginPage(steps.getDriver());
        loginPage.open();
        loginPage.login(USERNAME, INCORRECT_PASSWORD);

        boolean condition = steps.login(USERNAME, INCORRECT_PASSWORD).getErrorMessage().equals(ERROR_MESSAGE);

        Assert.assertTrue(condition);
    }

    @Test(description = "Login to rzd")
    public void oneCanLoginRzt(){

        boolean condition = steps.login(USERNAME, CORRECT_PASSWORD).getUsername().equals(NAME);

        Assert.assertTrue(condition);
    }


    @AfterMethod(description = "Stop steps")
    public void stopBrowser(){
        steps.close();
    }

}
