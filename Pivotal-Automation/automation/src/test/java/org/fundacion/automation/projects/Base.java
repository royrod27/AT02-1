
package org.fundacion.automation.projects;

import org.fundacion.common.drivers.Driver;
import org.fundacion.common.utilities.Log;
import org.fundacion.pages.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Administrator on 12/16/2016.
 */
public class Base {
  protected WebDriver driver;
  protected HomePage home;
  protected Log log = Log.getInstance();

  @BeforeSuite
  public void setSingletonDriver() {
    driver = Driver.getDriver().openBrowser();
  }

  @BeforeClass
  public void beforeClass() {
    if (driver == null) {
      driver = Driver.getDriver().openBrowser();
    }
  }

  @AfterClass
  public void logOutProfile() {
    home.LogOut();
  }


  @AfterSuite
  public void close() {
    driver.close();
  }
}
