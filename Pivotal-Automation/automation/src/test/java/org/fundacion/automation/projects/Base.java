
package org.fundacion.automation.projects;

import org.fundacion.common.drivers.Driver;
import org.fundacion.common.utilities.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Administrator on 12/16/2016.
 */
public class Base {
  protected WebDriver driver;
  protected Log log = Log.getInstance();

  @BeforeSuite
  public void setSingletonDriver() {
    driver = Driver.getDriver().openBrowser();
  }

  @AfterSuite
  public void close() {
    driver.close();
  }

}
