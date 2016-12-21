package org.fundacion.automation.workspaces;

import static org.testng.Assert.assertTrue;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.SettingsWorkspacePage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCreateWorkspace extends Base {
  CreateWorkspacePage workspace;
  WorkspacePage workspacePage;
  String testClass = "TestCreateWorkspace";

  /**
   * Login.
   */
  @BeforeMethod
  public void login() {
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
    LoginPage login = new LoginPage(driver);
    login.setUserName("Ariel.Vallejos@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("AT02david");
    home = login.clickSubmit();
  }

  @Test
  public void verifyWorkspaceIsCreated() {
    log.info(testClass, "Verify that is possible create a Workspace.");
    home.clickWorkspaceTab();
    workspace = home.clickCreateWorkspaceLink();
    workspace.setWorkspaceName("TestFromCode");
    workspacePage = workspace.clickCreateWorkspace();
    assertTrue(workspacePage.workspaceTitle("TestFromCode"));
    log.info(testClass, "Expect result: A new workspace was create success.");
  }

  /**
   * Delete workspace & logout.
   */
  @AfterMethod
  public void clean() {
    SettingsWorkspacePage settingsWorkspace = workspacePage.settingsWorkspace();
    settingsWorkspace.deleteWorkspace();
    settingsWorkspace.confirmDeleteWorkspace();
  }
}
