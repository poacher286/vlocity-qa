package com.vlocity.qe;

import com.vlocity.qe.baseClass.TestBase;
import com.vlocity.qe.pages.PG_Wiki;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This class verifies elements on the wikipedia homepage.
 */
public class WikipediaTest extends TestBase {
    private PG_Wiki pg_wiki;

    @BeforeMethod
    public void init() {
        pg_wiki = new PG_Wiki(this.driver);
    }

    @Test(description = "TC_001 Test to verify Wiki Slogan is present or not")
    public void sloganPresent() {
        pg_wiki.verifySloganIsPresent();
    }

    @Test(description = "TC_002 Test to verify Languages")
    public void verify_Language() {
        pg_wiki.verifyLanguageText();
    }

    @Test(description = "TC_003 Test to verify the hyperlinks for the Featured Languages work")
    public void verify_Response_HyperLink() throws IOException {
        pg_wiki.verifyHyperLink();
    }

}
