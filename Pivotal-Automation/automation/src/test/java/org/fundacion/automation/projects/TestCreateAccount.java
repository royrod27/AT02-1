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
  private String nameAccount = "Jala";

  @Test
  public void createProjectWithNewAccountTest() {
    log.info("TestCreateAccount", "Verify that is possible a account.");
    driver.get(configurationObj.getProperty("url"));
    LoginPage login = new LoginPage(driver);
    login.setUserName(configurationObj.getProperty("userName"));
    login.clickContinue();
    login.setPassword(configurationObj.getProperty("userPassword"));
    home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName(nameProject);
    project.clickNewAccount(nameAccount);
    ProjectMenuPage projectPage = project.clickCreate();
    SettingsPage settingProject = projectPage.clickSettings();
    assertTrue(settingProject.contentNameAccount(nameAccount), "Error the name of the account is diferent.");
    log.info("TestCreateAccount", "Expect result: The account was created.");
    settingProject.deleteProject();
  }
}
