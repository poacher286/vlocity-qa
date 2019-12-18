package com.vlocity.qe.baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        /*
            If the following driver version doesn't work with your Chrome version
            see https://sites.google.com/a/chromium.org/chromedriver/downloads
            and update it as needed.
        */
        WebDriverManager.chromedriver().version(System.getProperty("chrome.version")).setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get(System.getProperty("wikiURL"));
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
