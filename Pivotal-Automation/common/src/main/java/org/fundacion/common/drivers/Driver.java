package org.fundacion.common.drivers;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.fundacion.common.objectReader.ReadObject;
import org.fundacion.common.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver {

  private static Driver instance;
  public static WebDriver driver;
  private WebDriver chrome;

  private Driver() {
  }

  /**
   * This method is to open a browser.
   * It is possible implement more browsers.
   *
   * @return the driver of that browser was initialize.
   */
  public WebDriver openBrowser() throws IOException {
    if (chrome == null) {
      ReadObject object = new ReadObject();
      Properties configurationObj = object.getObjectRepository();
      driver = new WebDriverFactory(configurationObj.getProperty("browser")).getDriver();
      driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get(configurationObj.getProperty("url"));
      chrome = driver;
    } else if (chrome != null) {
      driver = chrome;
    }
    return driver;
  }

  /**
   * Method to obtain the instance of the
   * singleton driver.
   *
   * @return the instance.
   */
  public static Driver getDriver() {
    if (instance == null) {
      instance = new Driver();
    }
    return instance;
  }
}
