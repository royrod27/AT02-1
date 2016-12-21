package org.fundacion.automation.help;

import static org.testng.AssertJUnit.assertTrue;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.help.HelpPageMain;
import org.fundacion.pages.login.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



/**
 * Created by Fernando on 12/19/2016.
 */

public class TestVerifyQuickStartPage extends Base {

  String title = "Test Quick Start Page";
  String testClass = "TestVerifyQuickStartPage";

  /** Login Method.
   *
   */
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
  public void verifyQuickStartPageCorrectlyLoaded() {
    log.info(testClass, title);

    HelpPageMain helpPageMain = home.clickHelpPageButton();
    assertTrue(helpPageMain.verifyQuickStart());

    log.info(testClass, "Verify that Quick Start title is the same as the Quick Page tab title");
  }

}