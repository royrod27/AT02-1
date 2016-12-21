package org.fundacion.automation.projects;


import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.ProjectMenuPage;


import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class TestCreateProject extends Base{
  WebDriver driver;
  HomePage home;

  @BeforeTest
  public void setSingletonDriver() {
    driver = Driver.getDriver().openBrowser();
  }


  @Test
  public void verifyIfProjectIsCreated() {

    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");

    LoginPage login = new LoginPage(driver);
    login.setUserName("fernando.iquiza@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("MTat676435019");
    home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("ProjectCreated");
    project.clickSelectAccount("Fundacion Jala");
    ProjectMenuPage projectMenu = project.clickCreate();

    assertTrue(projectMenu.verifyProjectName("ProjectCreated"), "Error the name of the project is different. ");
    SettingsPage settingsPage = projectMenu.clickSettings();
    settingsPage.deleteProject();
    //driver.quit();
  }

  @AfterMethod
  public void logOutProfile(){
    home.LogOut();
  }

}
