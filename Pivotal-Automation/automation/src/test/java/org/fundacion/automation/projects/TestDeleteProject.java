package org.fundacion.automation.projects;

import static org.testng.Assert.assertFalse;

import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.ProjectsWorkSpacesPage;
import org.fundacion.pages.projects.SettingsPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by SergioLanda on 12/20/2016.
 */
public class TestDeleteProject extends Base {
  ProjectMenuPage projectMenu;
  String nameOfProject = "test01";
  String title = "Test Delete Project";
  String testClass = "TestDeleteProject";

  @Test
  public void testDeleteProject() {
    log.info("TestDeleteProject", "Verify that is possible delete a project.");
    driver.get(configurationObj.getProperty("url"));
    LoginPage login = new LoginPage(driver);
    login.setUserName(configurationObj.getProperty("userName"));
    login.clickContinue();
    login.setPassword(configurationObj.getProperty("userPassword"));
    home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName(nameOfProject);
    project.clickSelectAccount("Jala");
    projectMenu = project.clickCreate();
    log.info(testClass, title);
    SettingsPage settingsPage = projectMenu.clickSettings();
    home = settingsPage.deleteProject();
    ProjectsWorkSpacesPage projectsWorkSpacesPage = home.clickProjectsAndWorkSpaces();
    projectsWorkSpacesPage.clickLinkShowProjects(nameOfProject);
    assertFalse(projectsWorkSpacesPage.existProject());
    log.info(testClass, "Expect result: the project was created does not exist");
  }

}
