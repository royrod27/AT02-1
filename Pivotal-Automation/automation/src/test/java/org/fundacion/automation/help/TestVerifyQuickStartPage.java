package org.fundacion.automation.help;

import static org.testng.AssertJUnit.assertTrue;

import org.fundacion.automation.projects.Base;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.help.HelpPageMain;
import org.fundacion.pages.home.HomePage;

import org.fundacion.pages.login.LoginPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



/**
 * Created by Fernando on 12/19/2016.
 */

public class TestVerifyQuickStartPage extends Base {
  HomePage home;
  String title = "Test Quick Start Page";
  String testClass = "TestLearnMore";

  @Test
  public void verifyQuickStartPageCorrectlyLoaded() {
    log.info(testClass, title);

    driver = Driver.getDriver().openBrowser();
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
    LoginPage login = new LoginPage(driver);
    login.setUserName("fernando.iquiza@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("MTat676435019");
    home = login.clickSubmit();

    HelpPageMain helpPageMain = home.clickHelpPageButton();
    assertTrue(helpPageMain.verifyQuickStart());

    log.info(testClass, "Verify that Quick Start title is the same as the Quick Page tab title");
  }

  @AfterClass
  public void logOutProfile() {
    home.logOut();
  }
}