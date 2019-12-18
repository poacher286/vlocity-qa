package com.vlocity.qe.pages;

import com.vlocity.qe.baseClass.PageBase;
import com.vlocity.qe.utilities.RestAPIDriver;
import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final Map<String, String> langMap = new HashMap<>();
    {
        langMap.put("en", "English");
        langMap.put("ja", "日本語");
        langMap.put("es", "Español");
        langMap.put("de", "Deutsch");
        langMap.put("ru", "Русский");
        langMap.put("fr", "Français");
        langMap.put("it", "Italiano");
        langMap.put("zh", "中文");
        langMap.put("pt", "Português");
        langMap.put("pl", "Polski");
    }

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
     */
    public PG_Wiki(WebDriver driver) {
        super(driver);
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
    public void verifyHyperLink() throws IOException {
        for (WebElement ele : linkLanguages) {
            String langCode = ele.getAttribute("lang");
            linkLang = finder.findElement(By.xpath(XPATH_CENTRAL_FEATURE_LANGUAGE + "//a[contains(@id,'" + langCode + "')]"));
            String langLink = linkLang.getAttribute("href");
            log.info("Link for Language : " + this.langMap.get(langCode) + " is : {}", langLink);
            HttpResponse httpResponse = RestAPIDriver.callRestService(new HashMap<>(), langLink, null, "GET");
            int actualStatus = httpResponse.getStatusLine().getStatusCode();
            Assert.assertEquals(actualStatus, 200);
        }
    }

    /**
     * Method to verify Language present
     */
    public void verifyLanguageText() {
        for (WebElement ele : linkLanguages) {
            String langCode = ele.getAttribute("lang");
            linkLang = finder.findElement(By.xpath(XPATH_CENTRAL_FEATURE_LANGUAGE + "//a[contains(@id,'" + langCode + "')]/strong"));
            String language= linkLang.getText().trim();
            Assert.assertEquals(language, this.langMap.get(ele.getAttribute("lang")));
        }
    }
}
