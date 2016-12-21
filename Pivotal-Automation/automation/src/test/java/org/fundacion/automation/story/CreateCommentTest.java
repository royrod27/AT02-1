package org.fundacion.automation.story;

import org.fundacion.automation.projects.Base;
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

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by JorgeForero on 12/19/2016.
 */
public class CreateCommentTest extends Base {
  HomePage home;
  ProjectMenuPage projectMenuPage;
  SettingsPage settingsPage;
  StoryPage storyPage;

  @BeforeMethod
  public void logIn() {
    LoginPage login = new LoginPage(driver);
    login.setUserName("jorge.forero@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("jb&11235");
    home = login.clickSubmit();
  }

  @Test
  public void testCreateNewComment() {
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestStoryComment");
    project.clickSelectAccount("Maria");

    projectMenuPage = project.clickCreate();
    SideBarStoriesPage sideBarStories = projectMenuPage.sideBarStories();
    storyPage = sideBarStories.clickOnAddStoryButton();
    storyPage.setTitleStory("TestStoryComment");
    storyPage.clickOnCreateStory();
    storyPage.clickOnExpandStory();

    storyPage.setComment("Comment Test");

    assertTrue("Comment Test", storyPage.verifyExistCommentStory("Comment Test"));
  }

  @AfterMethod
  public void clean() {
    settingsPage = projectMenuPage.clickSettings();
    settingsPage.deleteProject();
  }

  @AfterClass
  public void logOutProfile() {
    home.LogOut();
  }

}
