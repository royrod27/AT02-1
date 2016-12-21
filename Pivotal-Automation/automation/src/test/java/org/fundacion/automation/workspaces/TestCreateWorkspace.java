package org.fundacion.automation.workspaces;

import static org.testng.Assert.assertTrue;

import org.fundacion.automation.projects.Base;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.SettingsWorkspacePage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by David on 12/15/2016.
 */
public class TestCreateWorkspace extends Base {
  HomePage home;
  CreateWorkspacePage workspace;
  WorkspacePage workspacePage;

  /**
   * Login.
   */
  @BeforeMethod
  public void login() {
    driver = Driver.getDriver().openBrowser();
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
    LoginPage login = new LoginPage(driver);
    login.setUserName("Ariel.Vallejos@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("AT02david");
    home = login.clickSubmit();
  }

  @Test
  public void verifyWorkspaceIsCreated() {
    log.info("TestCreateWorkspace", "Verify that is possible create a Workspace.");
    home.clickWorkspaceTab();
    workspace = home.clickCreateWorkspaceLink();
    workspace.setWorkspaceName("TestFromCode");
    workspacePage = workspace.clickCreateWorkspace();
    assertTrue(workspacePage.workspaceTitle("TestFromCode"));
    log.info("TestCreateWorkspace", "Expect result: A new workspace was create success.");
  }

  /**
   * Delete workspace & logout.
   */
  @AfterMethod
  public void clean() {
    SettingsWorkspacePage settingsWorkspace = workspacePage.settingsWorkspace();
    settingsWorkspace.deleteWorkspace();
    settingsWorkspace.confirmDeleteWorkspace();
    home.LogOut();
  }
}
