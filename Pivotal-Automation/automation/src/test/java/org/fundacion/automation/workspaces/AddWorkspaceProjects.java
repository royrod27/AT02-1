package org.fundacion.automation.workspaces;

import static org.testng.Assert.assertTrue;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.ManageWorkspacePage;
import org.fundacion.pages.workspaces.SettingsWorkspacePage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddWorkspaceProjects extends Base {
  CreateWorkspacePage createWorkspace;
  WorkspacePage workspacePage;
  ManageWorkspacePage manageWorkspace;
  String testClass = "AddWorkspaceProjects";

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
  public void verifyThatIsPosibleAddProjecsOnAWorkspace() {
    log.info(testClass, "Verify that is possible add a project on the workspace.");
    home.clickWorkspaceTab();
    createWorkspace = home.clickCreateWorkspaceLink();
    createWorkspace.setWorkspaceName("TestToAddProject");
    workspacePage = createWorkspace.clickCreateWorkspace();
    manageWorkspace = workspacePage.addProjectOption();
    manageWorkspace.addWorkspaceProject("Test");

    assertTrue(workspacePage.verifyProjectCreated("Test"));
    log.info(testClass, "Expect result: Project \"Test\" was add on the workspaces.");
  }

  /**
   * Delete workspace & Logout.
   */
  @AfterMethod
  public void clean() {
    SettingsWorkspacePage settingsWorkspace = workspacePage.settingsWorkspace();
    settingsWorkspace.deleteWorkspace();
    settingsWorkspace.confirmDeleteWorkspace();
  }
}