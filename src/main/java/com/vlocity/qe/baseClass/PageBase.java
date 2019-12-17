package com.vlocity.qe.baseClass;

import com.vlocity.qe.ElementFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageBase {
    private TestBase testBase;
    protected ElementFinder finder;
    protected Logger log = LoggerFactory.getLogger(PageBase.class);

    public PageBase(WebDriver driver, WebDriverWait wait){
        testBase = new TestBase();
        finder = new ElementFinder(driver);
    }


}
