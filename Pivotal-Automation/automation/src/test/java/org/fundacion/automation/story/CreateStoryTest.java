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

  /**
   * Login.
   */
  @BeforeMethod
  public void login() {
    driver.get(configurationObj.getProperty("url"));
    LoginPage login = new LoginPage(driver);
    login.setUserName(configurationObj.getProperty("userName"));
    login.clickContinue();
    login.setPassword(configurationObj.getProperty("userPassword"));
    home = login.clickSubmit();
  }

  @Test
  public void testCreateNewStory() {
    log.info("CreateStoryTest", "Verify that is possible create a Story on the project.");
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestStory");
    project.clickSelectAccount("Jala");

    projectMenuPage = project.clickCreate();
    SideBarStoriesPage sideBarStories = projectMenuPage.sideBarStories();
    storyPage = sideBarStories.clickOnAddStoryButton();
    storyPage.setTitleStory("TestStory");
    storyPage.clickOnCreateStory();
    storyPage.clickOnExpandStory();

    assertEquals("TestStory", storyPage.getStoryName());
    log.info("CreateStoryTest", "Expect result: Story test was add on the project.");
  }

  /**
   * Delete project, story & logout.
   */
  @AfterMethod
  public void clean() {
    storyPage.clickDeleteStory();
    settingsPage = projectMenuPage.clickSettings();
    settingsPage.deleteProject();
  }
}
