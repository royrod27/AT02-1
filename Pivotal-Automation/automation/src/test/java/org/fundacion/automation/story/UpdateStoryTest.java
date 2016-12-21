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
public class UpdateStoryTest extends Base {
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
  public void testUpdateStory() {
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestUpdateStory");
    project.clickSelectAccount("Maria");

    projectMenuPage = project.clickCreate();
    SideBarStoriesPage sideBarStories = projectMenuPage.sideBarStories();
    storyPage = sideBarStories.clickOnAddStoryButton();
    storyPage.setTitleStory("TestUpdateStory");
    storyPage.clickOnCreateStory();
    storyPage.clickOnExpandStory();

    storyPage.setStoryEstimateIn2();
    assertEquals("2 Points", storyPage.getStoryEstimate());
  }

  @AfterMethod
  public void clean() {
    storyPage.clickDeleteStory();
    settingsPage = projectMenuPage.clickSettings();
    settingsPage.deleteProject();
  }
}
