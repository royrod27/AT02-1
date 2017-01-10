package org.bdd.automation.task;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacion.automation.projects.Base;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.stories.SideBarStoriesPage;
import org.fundacion.pages.stories.StoryPage;
import org.fundacion.pages.task.TaskPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

/**
 * Created by Administrator on 1/10/2017.
 */
public class TaskSteps {

  WebDriver driver;
  LoginPage loginPage;
  ProjectMenuPage projectMenuPage;
  StoryPage storyPage;
  TaskPage taskPage;
  HomePage home;

  @Given("^I am logged on the pivotal tracker web page with e-mail (.*?) and password (.*?)$")
  public void login(String mail, String password) throws Throwable {
    driver = Driver.getDriver().openBrowser();
    loginPage = new LoginPage(driver);
    loginPage.setUserName(mail);
    loginPage.clickContinue();
    loginPage.setPassword(password);

  }

  @And("^I have a (.*?) project created$")
  public void iHaveAProjectNameProjectCreated(String projectName) throws Throwable {
    home = loginPage.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestStoryWithTask");
    project.clickSelectAccount("fundacion-jala");
    projectMenuPage = project.clickCreate();
  }

  @And("^I have a (.*?)Story created$")
  public void createStory(String storyName) throws Throwable {
    SideBarStoriesPage sideBarStories = projectMenuPage.sideBarStories();
    storyPage = sideBarStories.clickOnAddStoryButton();
    storyPage.setTitleStory("TestStory");
  }

  @And("^I have a task (.*?) created$")
  public void createTask(String taskName) throws Throwable {
    taskPage = storyPage.clickCreateTask(driver);
    taskPage.addTask(taskName);
  }

  @When("^I delete (.*?)$")
  public void deleteTask(String taskName) throws Throwable {
    taskPage.deleteTask(taskName);
  }


  @Then("^(.*?) should be deleted$")
  public void taskDeletedVerification(String taskName) throws Throwable {
    assertEquals(0,taskPage.sizeContentNameTask(taskName));
  }
}
