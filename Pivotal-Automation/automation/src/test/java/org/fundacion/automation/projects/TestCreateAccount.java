package org.fundacion.automation.projects;

import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class TestCreateAccount extends Base{
  private WebDriver driver;
  WebDriverWait wait;
  private String nameProject = "ProjectCreateNew3";
  private String nameAccount = "AccountNew3";
  List data = new ArrayList();
  HomePage home;

  @Test
  public void createProjectWithNewAccountTest() {

    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
    LoginPage login = new LoginPage(driver);
    login.setUserName("angelica.rodriguez@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("At24062406");
    home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName(nameProject);
    project.clickNewAccount(nameAccount);
    ProjectMenuPage projectPage = project.clickCreate();
    SettingsPage settingProject = projectPage.clickSettings();
    assertTrue(settingProject.contentNameAccount(nameAccount), "Error the name of the account is diferent.");
    settingProject.deleteProject();
   // driver.quit();
  }

  @AfterMethod
  public void logOutProfile(){
    home.LogOut();
  }

}
