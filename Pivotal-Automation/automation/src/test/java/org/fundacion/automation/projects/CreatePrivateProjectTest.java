package org.fundacion.automation.projects;

import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 12/13/2016.
 */
public class CreatePrivateProjectTest extends Base {
  WebDriver driver;
  HomePage home;

  @Test(priority = 2)
  public void createPrivateProject() {

    driver = Driver.getDriver().openBrowser();
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
    LoginPage login = new LoginPage(driver);
    login.setUserName("Roy.Rodriguez@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("Sabbath27");
    home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    String nameOfProject = "projectTestTwo";
    project.setProjectName(nameOfProject);
    project.clickSelectAccount("Price");
    project.selectPrivacy("private");
    ProjectMenuPage projectMenuPage = project.clickCreate();
    SettingsPage settingsPage = projectMenuPage.clickSettings();

    boolean isPrivate = settingsPage.verifyPrivateAccess();

    assertTrue(isPrivate, "project is not private");
    settingsPage.deleteProject();
  }

  @AfterMethod
  public void logOutProfile(){
    home.logOut();
  }

}
