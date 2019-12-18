package com.vlocity.qe.baseClass;

import com.vlocity.qe.elementFinder.ElementFinder;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageBase {
    protected ElementFinder finder;
    protected Logger log = LoggerFactory.getLogger(PageBase.class);

    public PageBase(WebDriver driver) {
        finder = new ElementFinder(driver);
    }

}