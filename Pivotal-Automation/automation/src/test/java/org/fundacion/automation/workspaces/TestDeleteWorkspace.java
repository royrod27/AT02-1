package org.fundacion.automation.workspaces;

import static org.testng.Assert.assertFalse;

import org.fundacion.automation.projects.Base;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.SettingsWorkspacePage;
import org.fundacion.pages.workspaces.WorkspaceListPage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by David on 12/16/2016.
 */
public class TestDeleteWorkspace extends Base {
  HomePage home;
  CreateWorkspacePage workspace;
  WorkspacePage workspacePage;
  WorkspaceListPage listWorkspaces;
  SettingsWorkspacePage settingsWorkspace;

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
  public void verifyWorkspaceIsDeleted() {
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
  }

  @AfterMethod
  public void clean() {
    home.LogOut();
  }
}
