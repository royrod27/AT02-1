package org.fundacion.automation.workspaces;

import static org.testng.Assert.assertFalse;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.ManageWorkspacePage;
import org.fundacion.pages.workspaces.SettingsWorkspacePage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveWorkspaceProjects extends Base {
  CreateWorkspacePage createWorkspace;
  WorkspacePage workspacePage;
  ManageWorkspacePage manageWorkspace;
  String testClass = "RemoveWorkspaceProjects";

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
  public void verifyThatIsPosibleRemoveProjecsOnAWorkspace() {
    log.info(testClass, "Verify that is possible remove a project on the workspace.");
    home.clickWorkspaceTab();
    createWorkspace = home.clickCreateWorkspaceLink();
    createWorkspace.setWorkspaceName("RemoveProjectOnWorkspace");
    workspacePage = createWorkspace.clickCreateWorkspace();

    manageWorkspace = workspacePage.addProjectOption();
    manageWorkspace.addWorkspaceProject("Test");

    workspacePage.addProjectOption();
    manageWorkspace.removeProject("Test");

    assertFalse(workspacePage.verifyProjectCreated("Test"));
    log.info(testClass, "Expect result: Project was remove from the workspace.");
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
