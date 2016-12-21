package org.fundacion.automation.projects;

import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class ModifyProjectTest extends Base {
  WebDriver driver;
  HomePage home;

  @Test
  public void testCreateProject() {

    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");

    LoginPage login = new LoginPage(driver);

    login.setUserName("gualy_vc@hotmail.com");
    login.clickContinue();
    login.setPassword("password123");
    home = login.clickSubmit();
    CreateProjectPage newProject = home.clickCreateProject();

    newProject.setProjectName("TestName");
    newProject.clickSelectAccount("Jala");
    ProjectMenuPage projectMenuPage = newProject.clickCreate();

    //Change the name of the project
    SettingsPage settingsPage = projectMenuPage.clickSettings();
    String projectNameChanged = "TestNameChanged";
    settingsPage.editProjectName(projectNameChanged);
    assertTrue(driver.findElement(settingsPage.getTitleProject(projectNameChanged)).isDisplayed(),
            "Error the name of the project is different.");

    //Deleting the project
    settingsPage.deleteProject();
   // driver.quit();
  }

  @AfterMethod
  public void logOutProfile(){
    home.LogOut();
  }
}