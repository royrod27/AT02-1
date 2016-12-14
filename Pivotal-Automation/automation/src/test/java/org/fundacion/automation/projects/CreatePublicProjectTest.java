package org.fundacion.automation.projects;

import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;


/**
 * Created by Administrator on 12/13/2016.
 */
public class CreatePublicProjectTest {
  @Test
  public void testCreatePublicProject() {
    System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.pivotaltracker.com/signin");

    LoginPage login = new LoginPage(driver);
    login.setUserName("jorge.forero@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("jb&11235");
    HomePage home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestPublic");
    project.clickSelectAccount("Maria");
    project.selectPrivacy("public");

    ProjectMenuPage projectMenuPage = project.clickCreate();
    SettingsPage settingsPage = projectMenuPage.clickSettings();

    boolean isPrivate = settingsPage.verifyPrivateAccess();

    assertFalse(isPrivate, "project is public");
    settingsPage.deleteProject();

    driver.quit();
  }
}
