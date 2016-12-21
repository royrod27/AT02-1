package org.fundacion.automation.story;

import static org.testng.AssertJUnit.assertFalse;

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
public class DeleteStoryTest extends Base {
  ProjectMenuPage projectMenuPage;
  SettingsPage settingsPage;
  StoryPage storyPage;

  /**
   * Login.
   */
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
  public void testDeleteAStory() {
    log.info("DeleteStoryTest" , "Verify that is possible delete a story of a project.");
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestDeleteStory");
    project.clickSelectAccount("Maria");

    projectMenuPage = project.clickCreate();
    SideBarStoriesPage sideBarStories = projectMenuPage.sideBarStories();
    storyPage = sideBarStories.clickOnAddStoryButton();
    storyPage.setTitleStory("TestDeleteStory");
    storyPage.clickOnCreateStory();
    storyPage.clickOnExpandStory();

    storyPage.clickDeleteStory();

    assertFalse(storyPage.verifyDeleteStory("TestDeleteStory"));
    log.info("DeleteStoryTest", "Expect result: Story was remove from the projects.");
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
