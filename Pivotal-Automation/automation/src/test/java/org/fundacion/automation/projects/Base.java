
package org.fundacion.automation.projects;

import org.fundacion.common.drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by Administrator on 12/16/2016.
 */
public class Base {
  WebDriver driver;

  @BeforeSuite
  public void setSingletonDriver(){
    driver = Driver.getDriver().openBrowser();
  }

  @AfterSuite
  public void close() {
    driver.close();
  }

}
