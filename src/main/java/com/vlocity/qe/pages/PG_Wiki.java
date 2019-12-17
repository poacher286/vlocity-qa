package com.vlocity.qe.pages;

import com.vlocity.qe.baseClass.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PG_Wiki extends PageBase {
    private static final String EXP_SLOGAN = "The Free Encyclopedia";
    private static final String SLOGAN_CLASS = "localized-slogan";
    private WebElement slogan = finder.findElement(By.className(SLOGAN_CLASS));

    public PG_Wiki(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void verifySloganIsPresent() {
        Assert.assertNotNull(slogan, String.format("Unable to find slogan div by class: %s", SLOGAN_CLASS));
        log.info("Slogan text is {}", slogan.getText());
        Assert.assertEquals(slogan.getText(), EXP_SLOGAN);
    }
}
