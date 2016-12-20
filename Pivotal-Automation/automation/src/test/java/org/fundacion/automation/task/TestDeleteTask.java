package org.fundacion.automation.task;

import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.fundacion.pages.stories.SideBarStoriesPage;
import org.fundacion.pages.stories.StoryPage;
import org.fundacion.pages.task.TaskPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

/**
 * Created by Angelica Rodriguez on 12/19/2016.
 */
public class TestDeleteTask {

    WebDriver driver;
    HomePage home;
    ProjectMenuPage projectMenuPage;
    StoryPage storyPage;
    SettingsPage settingsPage;

    @Test
    public void testDeleteTask() {

        driver = Driver.getDriver().openBrowser();
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

        TaskPage userStoryPage = storyPage.clickCreateTask(driver);
        userStoryPage.addTask("new task3");
        userStoryPage.addTask("new task4");
        userStoryPage.addTask("new task5");
        userStoryPage.addTask("new task6");
        userStoryPage.addTask("new task7");
        userStoryPage.deleteTask("new task4");
        storyPage.clickOnCreateStory();
        storyPage.clickOnExpandStory();
        assertFalse(userStoryPage.contentNameTask("new task4"));
    }

    @AfterMethod
    public void clean(){
        storyPage.clickDeleteStory();
        settingsPage = projectMenuPage.clickSettings();
        settingsPage.deleteProject();
    }

    @AfterClass
    public void logOutProfile() {
        home.LogOut();
    }
}
