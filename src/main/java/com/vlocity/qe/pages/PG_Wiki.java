package com.vlocity.qe.pages;

import com.vlocity.qe.baseClass.PageBase;
import com.vlocity.qe.utilities.RestAPIDriver;
import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

public class PG_Wiki extends PageBase {
    /**
     * All Expected Results
     */
    private static final String EXP_SLOGAN = "The Free Encyclopedia";

    /**
     * All Xpath
     */
    private static final String CLS_SLOGAN = "localized-slogan";
    private static final String XPATH_CENTRAL_FEATURE_LANGUAGE = "//div[@class='central-featured']//div";


    /**
     * All Webelements of page
     */
    private WebElement txtslogan = finder.findElement(By.className(CLS_SLOGAN));
    private WebElement linkLang;
    private List<WebElement> linkLanguages = finder.findElements(By.xpath(XPATH_CENTRAL_FEATURE_LANGUAGE));

    /**
     * Page Constructor
     *
     * @param driver
     * @param wait
     */
    public PG_Wiki(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Method to verify Slogan is present
     */
    public void verifySloganIsPresent() {
        Assert.assertNotNull(txtslogan, String.format("Unable to find slogan div by class: %s", CLS_SLOGAN));
        log.info("Slogan text is {}", txtslogan.getText());
        Assert.assertEquals(txtslogan.getText(), EXP_SLOGAN);
    }

    /**
     * Method to verify Language Hyperlinks
     */
    public void verifyHyperLink() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        for (WebElement ele : linkLanguages) {
            linkLang = finder.findElement(By.xpath(XPATH_CENTRAL_FEATURE_LANGUAGE + "//a[contains(@id,'" + ele.getAttribute("lang") + "')]"));
            HttpResponse httpResponse = RestAPIDriver.callRestService(new HashMap<>(), linkLang.getAttribute("href"), null, "GET");
            int actualStatus = httpResponse.getStatusLine().getStatusCode();
            Assert.assertEquals(actualStatus, 200);
        }
    }
}
