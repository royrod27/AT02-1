package org.fundacion.automation.help;

import static org.testng.AssertJUnit.assertTrue;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.help.FeedBackPage;
import org.fundacion.pages.login.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



/**
 * Created by Administrator on 12/21/2016.
 */
public class TestFeedBack extends Base {
  String title = "Test FeedBack Page";
  String testClass = "TestFeedBack";

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
  public void verifyFeedBackPageTitleIsTheSameAsPageTab() {
    log.info(testClass, title);

    FeedBackPage feedBackPage = home.clickGiveUsFeedBackLink();
    assertTrue(feedBackPage.verifyFeedBack());

    log.info(testClass, "Verify that FeedBack page title is the same as the feedback tab title");
  }
}
