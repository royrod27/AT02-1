package org.fundacion.common.listener;

import java.io.IOException;

import org.fundacion.common.drivers.Driver;
import org.fundacion.common.objectReader.ReadObject;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.xml.XmlSuite;


public class SuiteListener implements ISuiteListener {
  WebDriver driver;

  @Override
  public void onStart(ISuite suite) {

  }

  @Override
  public void onFinish(ISuite suite) {
    XmlSuite xmlSuite = suite.getXmlSuite();
    if (xmlSuite.getTests().isEmpty()) {
      driver = Driver.getDriver().getWebDriver();
      if (driver != null) {
        driver.quit();
      }
    }
  }
}