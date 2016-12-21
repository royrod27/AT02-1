package org.fundacion.automation.story;

import static org.testng.AssertJUnit.assertTrue;

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
public class CreateCommentTest extends Base {
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
  public void testCreateNewComment() {
    log.info("CreateCommentTest", "Verify that is possible add a comment on the story.");
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
    log.info("CreateCommentTest", "Expect result: Comment test was add on the story.");
  }

  /**
   * Delete project & logout.
   */
  @AfterMethod
  public void clean() {
    settingsPage = projectMenuPage.clickSettings();
    settingsPage.deleteProject();
  }
}
