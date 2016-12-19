package org.fundacion.automation.story;

import org.fundacion.automation.projects.Base;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.fundacion.pages.stories.SideBarStoriesPage;
import org.fundacion.pages.stories.StoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Administrator on 12/15/2016.
 */
public class CreateStoryTest extends Base {
  WebDriver driver;
  HomePage home;
  ProjectMenuPage projectMenuPage;
  SettingsPage settingsPage;
  StoryPage storyPage;

  @BeforeClass
  public void setup() {
    driver = Driver.getDriver().openBrowser();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.pivotaltracker.com/signin");
  }

  @BeforeMethod
  public void logIn() {
    LoginPage login = new LoginPage(driver);
    login.setUserName("jorge.forero@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("jb&11235");
    home = login.clickSubmit();
  }

  @Test
  public void testCreateNewStory() {
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestStory");
    project.clickSelectAccount("Maria");

    projectMenuPage = project.clickCreate();
    SideBarStoriesPage sideBarStories = projectMenuPage.sideBarStories();
    storyPage = sideBarStories.clickOnAddStoryButton();
    storyPage.setTitleStory("TestStory");
    storyPage.clickOnCreateStory();
    storyPage.clickOnExpandStory();

    assertEquals("TestStory",storyPage.getStoryName());
  }

  @AfterMethod
  public void clean(){
    storyPage.clickDeleteStory();
    settingsPage = projectMenuPage.clickSettings();
    settingsPage.deleteProject();
  }

  @AfterClass
  public void logOutProfile() {
    home.LogOut();
  }
}
