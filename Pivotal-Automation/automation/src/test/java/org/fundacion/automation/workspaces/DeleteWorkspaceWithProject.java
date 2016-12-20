package org.fundacion.automation.workspaces;

import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

/**
 * Created by David on 12/19/2016.
 */
public class DeleteWorkspaceWithProject {
  WebDriver driver;

  @Test
  public void verifyWorkspaceIsDeletedWithProject() {

    System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
    driver = Driver.getDriver().openBrowser();
    driver.get("https://www.pivotaltracker.com/signin");
    LoginPage login = new LoginPage(driver);
    login.setUserName("Ariel.Vallejos@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("AT02david");
    HomePage home = login.clickSubmit();

    home.clickWorkspaceTab();
    CreateWorkspacePage workspace = home.clickCreateWorkspaceLink();
    workspace.setWorkspaceName("WorkspaceWithProject");
    WorkspacePage workspacePage = workspace.clickCreateWorkspace();

    ManageWorkspacePage manageWorkspace = workspacePage.addProjectOption();
    manageWorkspace.addWorkspaceProject("Test");


    SettingsWorkspacePage settingsWorkspace = workspacePage.settingsWorkspace();
    settingsWorkspace.deleteWorkspace();
    settingsWorkspace.confirmDeleteWorkspace();

    WorkspaceListPage listWorkspaces = home.clickWorkspaceTab();

    assertFalse(listWorkspaces.verifyProjectWasDeleted());
  }
}
