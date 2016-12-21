package org.fundacion.automation.help;

import org.fundacion.automation.projects.Base;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.help.HelpPageMain;
import org.fundacion.pages.help.LearnMorePage;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Fernando on 21/12/2016.
 */
public class TestLearnMore extends Base {
  HomePage home;

  @BeforeMethod
  public void login() {
    driver.get(configurationObj.getProperty("url"));
    LoginPage login = new LoginPage(driver);
    login.setUserName(configurationObj.getProperty("userName"));
    login.clickContinue();
    login.setPassword(configurationObj.getProperty("userPassword"));
    home = login.clickSubmit();
  }

  @Test
  public void verifyLearnMorePageTitleCorrectlyLoaded() {
    LearnMorePage learnMorePage = home.clickLearnMoreButton();

    assertTrue(learnMorePage.verifyLearnMore());

  }

  @AfterClass
  public void logOutProfile() {
    home.logOut();
  }
}
