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
 * Created by JorgeForero on 12/20/2016.
 */
public class UpdateStoryEstimateTest extends Base {
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
  public void testUpdateStory() {
    log.info("UpdateStoryEstimateTest", "Verify that is possible update estimate point in a Story.");
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestUpdateEstimatePoint");
    project.clickSelectAccount("Jala");

    projectMenuPage = project.clickCreate();
    SideBarStoriesPage sideBarStories = projectMenuPage.sideBarStories();
    storyPage = sideBarStories.clickOnAddStoryButton();
    storyPage.setTitleStory("TestUpdateEstimatePoint");
    storyPage.clickOnCreateStory();
    storyPage.clickOnExpandStory();

    storyPage.setStoryEstimateIn2();
    assertEquals("2 Points", storyPage.getStoryEstimate());
    log.info("UpdateStoryEstimateTest", "Expect result: Estimate Story was update to 2 points.");
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
