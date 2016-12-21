package org.fundacion.automation.story;

import static org.testng.AssertJUnit.assertEquals;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.fundacion.pages.stories.SideBarStoriesPage;
import org.fundacion.pages.stories.StoryPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by JorgeForero on 12/19/2016.
 */
public class CreateDescriptionTest extends Base {
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
  public void testCreateDescription() {
    log.info("CreateDescriptionTest", "Verify that is possible add a description on the story.");
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestCreateStoryDescription");
    project.clickSelectAccount("Maria");

    projectMenuPage = project.clickCreate();
    SideBarStoriesPage sideBarStories = projectMenuPage.sideBarStories();
    storyPage = sideBarStories.clickOnAddStoryButton();
    storyPage.setTitleStory("TestCreateStoryDescription");
    storyPage.clickOnCreateStory();
    storyPage.clickOnExpandStory();

    storyPage.setDescriptionTextarea("Description");

    assertEquals("Description", storyPage.getStoryDescription());
    log.info("CreateDescriptionTest", "Expect result: Description was add on the story.");
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
