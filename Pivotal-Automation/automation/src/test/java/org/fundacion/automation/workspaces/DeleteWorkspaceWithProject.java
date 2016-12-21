package org.fundacion.automation.workspaces;

import static org.testng.Assert.assertFalse;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.ManageWorkspacePage;
import org.fundacion.pages.workspaces.SettingsWorkspacePage;
import org.fundacion.pages.workspaces.WorkspaceListPage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteWorkspaceWithProject extends Base {
  CreateWorkspacePage createWorkspacePage;
  WorkspacePage workspacePage;
  ManageWorkspacePage manageWorkspace;
  SettingsWorkspacePage settingsWorkspace;
  WorkspaceListPage listWorkspaces;
  String testClass = "DeleteWorkspaceWithProject";

  /**
   * Login.
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
  public void verifyWorkspaceIsDeletedWithProject() {
    log.info(testClass, "Verify that is possible delete a workspace with projects added.");
    home.clickWorkspaceTab();
    createWorkspacePage = home.clickCreateWorkspaceLink();
    createWorkspacePage.setWorkspaceName("WorkspaceWithProject");
    workspacePage = createWorkspacePage.clickCreateWorkspace();

    manageWorkspace = workspacePage.addProjectOption();
    manageWorkspace.addWorkspaceProject("Test");

    settingsWorkspace = workspacePage.settingsWorkspace();
    settingsWorkspace.deleteWorkspace();
    settingsWorkspace.confirmDeleteWorkspace();

    listWorkspaces = home.clickWorkspaceTab();

    assertFalse(listWorkspaces.verifyProjectWasDeleted());
    log.info(testClass, "Expect result: Workspace with projects added was delete.");
  }
}
