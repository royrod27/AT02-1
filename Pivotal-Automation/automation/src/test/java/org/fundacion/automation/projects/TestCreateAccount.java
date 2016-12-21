package org.fundacion.automation.projects;

import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class TestCreateAccount extends Base {
  private String nameProject = "ProjectCreateNew3";
  private String nameAccount = "AccountNew3";

  @Test
  public void createProjectWithNewAccountTest() {

    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
    LoginPage login = new LoginPage(driver);
    login.setUserName("angelica.rodriguez@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("At24062406");
    home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName(nameProject);
    project.clickNewAccount(nameAccount);
    ProjectMenuPage projectPage = project.clickCreate();
    SettingsPage settingProject = projectPage.clickSettings();
    assertTrue(settingProject.contentNameAccount(nameAccount), "Error the name of the account is diferent.");
    settingProject.deleteProject();
  }

  @AfterTest
  public void logOutProfile() {
    home.LogOut();
  }

}
