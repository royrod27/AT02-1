package org.fundacion.automation.help;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.help.ApiDocumentationPage;
import org.fundacion.pages.help.ContactSupportPage;
import org.fundacion.pages.login.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 12/22/2016.
 */
public class TestApiDocumentation extends Base{
  String title = "Test Api Documentation Page";
  String testClass = "TestApiDocumentation";

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
  public void verifyApiDocTabPageContainsApiDocTitleEssentials() {
    log.info(testClass, title);

    log.info(testClass, "Verify that Api Documentation Tab Page has Essential keyword in the Title of Loaded Page");
  }
}


