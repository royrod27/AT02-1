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
import org.testng.annotations.BeforeMethod;
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
  public void testCannotCreateTaskWithoutName() {
    log.info(testClass, title);
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestStoryWithTask");
    project.clickSelectAccount("Jala");
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

