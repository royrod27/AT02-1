package org.fundacion.automation.projects;

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

/**
 * Created by Administrator on 12/13/2016.
 */
public class CreatePrivateProjectTest {
  WebDriver driver;
  HomePage home;

  @BeforeMethod
  public void configure() {
    System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.pivotaltracker.com/signin");
    LoginPage login = new LoginPage(driver);
    login.setUserName("Roy.Rodriguez@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("Sabbath27");
    home = login.clickSubmit();
  }


  @Test(priority = 2)
  public void exampleTestNg() {

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
  public void close() {
    driver.quit();
  }
}
