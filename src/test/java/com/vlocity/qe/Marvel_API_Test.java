package com.vlocity.qe;

import com.vlocity.qe.baseClass.TestBase;
import com.vlocity.qe.pages.PG_Marvel;
import org.testng.annotations.BeforeMethod;

public class Marvel_API_Test extends TestBase {

    private PG_Marvel pgMarvel;

    @BeforeMethod
    public void init() {
        pgMarvel = new PG_Marvel(this.driver);
    }


}
