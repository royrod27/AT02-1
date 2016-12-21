package org.fundacion.automation.projects;

import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;


/**
 * Created by Administrator on 12/13/2016.
 */
public class CreatePublicProjectTest extends Base{
  WebDriver driver;
  HomePage home;

  @Test
  public void testCreatePublicProject() {
//    driver = Driver.getDriver().openBrowser();
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
    LoginPage login = new LoginPage(driver);
    login.setUserName("jorge.forero@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("jb&11235");
    home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestPublic");
    project.clickSelectAccount("Maria");
    project.selectPrivacy("public");

    ProjectMenuPage projectMenuPage = project.clickCreate();
    SettingsPage settingsPage = projectMenuPage.clickSettings();

    boolean isPrivate = settingsPage.verifyPrivateAccess();

    assertFalse(isPrivate, "project is public");
    settingsPage.deleteProject();

  }

  @AfterMethod
  public void logOutProfile(){
    home.logOut();
  }

}
