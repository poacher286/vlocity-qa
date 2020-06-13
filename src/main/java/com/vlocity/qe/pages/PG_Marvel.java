package com.vlocity.qe.pages;

import com.vlocity.qe.baseClass.PageBase;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class PG_Marvel extends PageBase {

    public PG_Marvel(WebDriver driver) {
        super(driver);
    }

    public static final String PRIV_KEY = System.getProperty("PRIV_KEY");
    public static final String PUBLIC_KEY = System.getProperty("PUBLIC_KEY");

    private Date date = new Date();
    private long time = date.getTime();





}
