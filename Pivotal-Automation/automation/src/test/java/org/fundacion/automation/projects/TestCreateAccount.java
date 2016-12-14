package org.fundacion.automation.projects;

import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class TestCreateAccount {
  private WebDriver driver;
  WebDriverWait wait;
  private String nameProject = "ProjectCreateNew3";
  private String nameAccount = "AccountNew3";
  List data = new ArrayList();
  ;


  @Test
  public void createProjectWithNewAccountTest() {
    System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.pivotaltracker.com/signin");
    LoginPage login = new LoginPage(driver);
    login.setUserName("angelica.rodriguez@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("At24062406");
    HomePage home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName(nameProject);
    project.clickNewAccount(nameAccount);
    ProjectMenuPage projectPage = project.clickCreate();
    SettingsPage settingProject = projectPage.clickSettings();
    assertTrue(settingProject.contentNameAccount(nameAccount), "Error the name of the account is diferent.");
    settingProject.deleteProject();
    driver.quit();

  }

}
