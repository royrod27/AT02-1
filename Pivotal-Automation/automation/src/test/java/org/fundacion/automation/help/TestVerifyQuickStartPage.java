package org.fundacion.automation.projects;

import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.HelpPageMain;
import org.fundacion.pages.projects.QuickStartHelp;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Administrator on 12/19/2016.
 */

public class TestVerifyQuickStartPage extends Base {

  HomePage home;

  @Test
  public void verifyQuickStartPageCorrectlyLoaded() {
    driver = Driver.getDriver().openBrowser();
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
    LoginPage login = new LoginPage(driver);
    login.setUserName("fernando.iquiza@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("MTat676435019");
    home = login.clickSubmit();

    HelpPageMain helpPageMain = home.clickHelpPageButton();

    assertTrue(helpPageMain.changeTab());


  }
}