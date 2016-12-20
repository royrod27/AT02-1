package org.fundacion.automation;

import org.fundacion.common.drivers.Driver;
import org.fundacion.common.utilities.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by SergioLanda on 12/20/2016.
 */
public abstract class ABase {

    protected WebDriver driver;
    protected Log log = Log.getInstance();

    @BeforeSuite
    public void setSingletonDriver(){
        this.driver = Driver.getDriver().openBrowser();
    }

    @AfterSuite
    public void close() {
        driver.close();
    }

}
