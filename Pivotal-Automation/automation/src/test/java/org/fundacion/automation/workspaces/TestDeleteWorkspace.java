package org.fundacion.automation.workspaces;

import static org.testng.Assert.assertFalse;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.SettingsWorkspacePage;
import org.fundacion.pages.workspaces.WorkspaceListPage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDeleteWorkspace extends Base {
  CreateWorkspacePage workspace;
  WorkspacePage workspacePage;
  WorkspaceListPage listWorkspaces;
  SettingsWorkspacePage settingsWorkspace;
  String testClass = "TestDeleteWorkspace";

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
  public void verifyWorkspaceIsDeleted() {
    log.info(testClass, "Verify that is possible delete a workspace.");
    home.clickWorkspaceTab();
    workspace = home.clickCreateWorkspaceLink();
    workspace.setWorkspaceName("TestToDelete");
    workspacePage = workspace.clickCreateWorkspace();

    workspacePage.goToHome();
    listWorkspaces = home.clickWorkspaceTab();
    listWorkspaces.findWorkspaceOnList("TestToDelete");

    settingsWorkspace = workspacePage.settingsWorkspace();
    settingsWorkspace.deleteWorkspace();
    settingsWorkspace.confirmDeleteWorkspace();

    home.clickWorkspaceTab();
    assertFalse(listWorkspaces.verifyProjectWasDeleted());
    log.info(testClass, "Expect result: Workspace was delete success.");
  }
}
