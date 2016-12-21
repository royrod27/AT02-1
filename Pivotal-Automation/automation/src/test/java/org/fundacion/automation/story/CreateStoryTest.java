package org.fundacion.automation.story;

import static org.testng.AssertJUnit.assertEquals;

import org.fundacion.automation.projects.Base;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.fundacion.pages.stories.SideBarStoriesPage;
import org.fundacion.pages.stories.StoryPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by JorgeForero on 12/15/2016.
 */
public class CreateStoryTest extends Base {
  ProjectMenuPage projectMenuPage;
  SettingsPage settingsPage;
  StoryPage storyPage;

  @BeforeMethod
  public void logIn() {
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
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

    assertEquals("TestStory", storyPage.getStoryName());
  }

  @AfterMethod
  public void clean() {
    storyPage.clickDeleteStory();
    settingsPage = projectMenuPage.clickSettings();
    settingsPage.deleteProject();
  }
}
