package org.fundacion.automation.workspaces;

import org.fundacion.automation.projects.Base;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by David on 12/15/2016.
 */
public class TestCreateWorkspace extends Base {
  WebDriver driver;
  HomePage home;

  @Test
  public void verifyWorkspaceIsCreated() {
    System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
    driver = Driver.getDriver().openBrowser();
    driver.get("https://www.pivotaltracker.com/signin");
    LoginPage login = new LoginPage(driver);
    login.setUserName("Ariel.Vallejos@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("AT02david");
    home = login.clickSubmit();

    home.clickWorkspaceTab();
    CreateWorkspacePage workspace = home.clickCreateWorkspaceLink();
    workspace.setWorkspaceName("TestFromCode");
    WorkspacePage workspacePage = workspace.clickCreateWorkspace();
    assertTrue(workspacePage.workspaceTitle("TestFromCode"));
  }

  @AfterTest
  public void logOutProfile() {
    home.LogOut();
  }
}
