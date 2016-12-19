package org.fundacion.common.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

  private static Driver instance;
  private static WebDriver driver;
  private WebDriver chrome;

  private Driver() {
  }

  /**
   * This method is to open a browser.
   * It is possible implement more browsers.
   * @return the driver of that browser was initialize.
   */
  public WebDriver openBrowser() {
    if (chrome == null) {
      System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("https://www.pivotaltracker.com/signin");
      chrome = driver;
    } else if (chrome != null) {
      driver = chrome;
    }
    return driver;
  }

  /**
   * Method to obtain the instance of the
   * singleton driver.
   * @return the instance.
   */
  public static Driver getDriver() {
    if (instance == null) {
      instance = new Driver();
    }
    return instance;
  }
}
