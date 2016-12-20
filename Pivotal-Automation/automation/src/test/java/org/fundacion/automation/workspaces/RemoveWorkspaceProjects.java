package org.fundacion.automation.workspaces;

import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.ManageWorkspacePage;
import org.fundacion.pages.workspaces.WorkspacePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by David on 12/16/2016.
 */
public class RemoveWorkspaceProjects {
  WebDriver driver;

  @Test
  public void verifyThatIsPosibleRemoveProjecsOnAWorkspace() {
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
    workspace.setWorkspaceName("RemoveTest");
    WorkspacePage workspacePage = workspace.clickCreateWorkspace();

    ManageWorkspacePage manageWorkspace = workspacePage.addProjectOption();
    manageWorkspace.addWorkspaceProject("Test");

    workspacePage.addProjectOption();
    manageWorkspace.removeProject("Test");

    //assertTrue( );
  }
}
