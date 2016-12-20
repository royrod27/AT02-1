package org.fundacion.automation.workspaces;

import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.SettingsWorkspacePage;
import org.fundacion.pages.workspaces.WorkspaceListPage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

/**
 * Created by David on 12/16/2016.
 */
public class TestDeleteWorkspace {
  WebDriver driver;

  @Test
  public void verifyWorkspaceIsDeleted() {

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
    workspace.setWorkspaceName("TestToDelete");
    WorkspacePage workspacePage = workspace.clickCreateWorkspace();

    workspacePage.goToHome();
    WorkspaceListPage listWorkspaces = home.clickWorkspaceTab();
    listWorkspaces.deleteWorkspace("TestToDelete");

    SettingsWorkspacePage settingsWorkspace = workspacePage.settingsWorkspace();
    settingsWorkspace.deleteWorkspace();
    settingsWorkspace.confirmDeleteWorkspace();

    home.clickWorkspaceTab();
    assertFalse(listWorkspaces.verifyProjectWasDeleted());
  }
}
