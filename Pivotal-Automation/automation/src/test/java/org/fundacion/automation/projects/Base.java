
package org.fundacion.automation.projects;

import org.fundacion.common.drivers.Driver;
import org.fundacion.common.objectReader.ReadObject;
import org.fundacion.common.utilities.Log;
import org.fundacion.pages.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 12/16/2016.
 */
public class Base {
  protected WebDriver driver;
  protected HomePage home;
  protected Log log = Log.getInstance();
  protected Properties configurationObj;

  @BeforeSuite
  public void setSingletonDriver() throws IOException {
    driver = Driver.getDriver().openBrowser();
    ReadObject object = new ReadObject();
    configurationObj = object.getObjectRepository();
  }

  @BeforeClass
  public void beforeClass() throws IOException {
    if (driver == null) {
      driver = Driver.getDriver().openBrowser();
      ReadObject object = new ReadObject();
      configurationObj = object.getObjectRepository();
    }
  }

  @AfterClass
  public void logOutProfile() {
    home.logOut();
  }
}