package com.vlocity.qe.elementFinder;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Utility class to wrap Selenium Find methods.
 */
public class ElementFinder {
    private WebDriver driver;
    private Logger log = LoggerFactory.getLogger(ElementFinder.class);

    public ElementFinder(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method to get element
     * @param by
     * @return
     */
    public WebElement findElement(By by) {
        log.info("Using By {}", by.toString());
        WebElement value = null;
        try {
            value = driver.findElement(by);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return value;
    }

    /**
     * Method to get List of elements
     * @param by
     * @return
     */
    public List<WebElement> findElements(By by) {
        log.info("Using By {}", by.toString());
        return driver.findElements(by);
    }
}
