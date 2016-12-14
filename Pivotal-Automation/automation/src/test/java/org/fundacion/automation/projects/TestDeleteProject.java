package org.fundacion.automation.projects;

import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.ProjectsWorkSpacesPage;
import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;

public class TestDeleteProject {
  ProjectMenuPage projectMenu;
  WebDriver driver;

  @BeforeMethod
  public void testCreateProject() {
    System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.pivotaltracker.com/signin");

    LoginPage login = new LoginPage(driver);
    login.setUserName("sergio.landa@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("P@ssw0rd");
    HomePage home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("test01");
    project.clickSelectAccount("Fundacion Jala");
    projectMenu = project.clickCreate();
  }

  @Test
  public void testDeleteProject() {
    SettingsPage settingsPage = projectMenu.clickSettings();
    HomePage homePage = settingsPage.deleteProject();
    ProjectsWorkSpacesPage projectsWorkSpacesPage = homePage.clickProjectsAndWorkSpaces();
    projectsWorkSpacesPage.clickLinkShowProjects();
    assertFalse(projectsWorkSpacesPage.existProject("test01"));
  }

  @AfterClass
  public void close() {
    driver.quit();
  }

}
