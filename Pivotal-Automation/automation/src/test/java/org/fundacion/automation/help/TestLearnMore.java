package org.fundacion.automation.help;

import static org.testng.Assert.assertTrue;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.help.LearnMorePage;
import org.fundacion.pages.login.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by Fernando on 21/12/2016.
 */
public class TestLearnMore extends Base {

  String title = "Test Learn More Page";
  String testClass = "TestLearnMore";

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
  public void verifyLearnMorePageTitleCorrectlyLoaded() {
    log.info(testClass, title);

    LearnMorePage learnMorePage = home.clickLearnMoreButton();
    assertTrue(learnMorePage.verifyLearnMore());

    log.info(testClass, "Verify that Learn More page title is the same as the Learn More tab");
  }
}
