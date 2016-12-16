package org.fundacion.automation.workspaces;

import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by David on 12/15/2016.
 */
public class TestCreateWorkspace {
  WebDriver driver;

  @Test
  public void verifyWorkspaceIsCreated() {
    System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
    driver = Driver.getDriver().openBrowser();
    driver.get("https://www.pivotaltracker.com/signin");
    LoginPage login = new LoginPage(driver);
    login.setUserName("Ariel.Vallejos@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("AT02david");
    HomePage home = login.clickSubmit();
    CreateWorkspacePage workspace = home.clickCreateWorkspace();
    workspace.setWorkspaceName("TestFromCode");
    WorkspacePage workspacePage = workspace.clickCreateWorkspace();
    assertTrue(workspacePage.workspaceTitle("TestFromCode"));
  }
}
