package org.fundacion.automation.help;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.help.ApiDocumentationPage;
import org.fundacion.pages.help.FeedBackPage;
import org.fundacion.pages.login.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Administrator on 12/22/2016.
 */
public class TestApiDocumentation extends Base{
  String title = "Test API Documentation Page";
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
  public void verifyApiDocumentationPageTitleIsTheSameAsPageTab() {
    log.info(testClass, title);

    ApiDocumentationPage apiDocumentationPage = home.clickApiDocumentationLink();
    assertTrue(apiDocumentationPage.verifyApiDocumentation());

    log.info(testClass, "Verify that API Docs page title >> Essentials << is contained in the Page tab title");
  }
}

