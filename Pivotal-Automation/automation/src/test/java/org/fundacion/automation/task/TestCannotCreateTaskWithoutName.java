package org.fundacion.automation.task;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.fundacion.pages.stories.SideBarStoriesPage;
import org.fundacion.pages.stories.StoryPage;
import org.fundacion.pages.task.TaskPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Angelica Rodriguez on 12/19/2016.
 */
public class TestCannotCreateTaskWithoutName extends Base {
  ProjectMenuPage projectMenuPage;
  StoryPage storyPage;
  SettingsPage settingsPage;
  String title = "Test cannot create task WithoutName";
  String testClass = "testCannotCreateTaskWithoutName";

  @Test
  public void testCannotCreateTaskWithoutName() {
    log.info(testClass, title);
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
    LoginPage login = new LoginPage(driver);
    login.setUserName("angelica.rodriguez@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("At24062406");
    home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestStoryWithTask");
    project.clickNewAccount("Task");
    projectMenuPage = project.clickCreate();
    SideBarStoriesPage sideBarStories = projectMenuPage.sideBarStories();
    storyPage = sideBarStories.clickOnAddStoryButton();
    storyPage.setTitleStory("TestStory");
    TaskPage taskPage = storyPage.clickCreateTask(driver);
    taskPage.addTask("");
    assertTrue(taskPage.alertDialog().contains("Cannot Save Task"));
    taskPage.clickButtonOk();
    storyPage.clickOnCreateStory();
    storyPage.clickOnExpandStory();
    assertEquals(0, taskPage.sizeContentNameTask(""));
    log.info(testClass, "Verify that the task is not created if it has no name");
  }

  @AfterMethod
  public void clean() {
    storyPage.clickDeleteStory();
    settingsPage = projectMenuPage.clickSettings();
    settingsPage.deleteProject();
  }
}
