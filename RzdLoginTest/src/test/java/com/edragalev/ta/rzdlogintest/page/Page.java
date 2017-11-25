package com.edragalev.ta.rzdlogintest.page;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver;

    public abstract void open();

    public Page(WebDriver driver)
    {
        this.driver = driver;
    }
}
