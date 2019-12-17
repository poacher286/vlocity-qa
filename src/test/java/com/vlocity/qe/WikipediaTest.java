package com.vlocity.qe;

import com.vlocity.qe.baseClass.TestBase;
import com.vlocity.qe.pages.PG_Wiki;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class verifies elements on the wikipedia homepage.
 */
public class WikipediaTest extends TestBase {
    private PG_Wiki pg_wiki;

    @BeforeMethod
    public void init() {
        pg_wiki = new PG_Wiki(this.driver, this.wait);
    }

    @Test
    public void sloganPresent() {
        pg_wiki.verifySloganIsPresent();
    }

}
