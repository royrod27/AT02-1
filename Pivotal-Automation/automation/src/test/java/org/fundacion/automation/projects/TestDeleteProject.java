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
  HomePage homePage;
  String title = "Test Delete Project";
  String testClass = "TestDeleteProject";

  /**
   * Delete one project created.
   */
  @BeforeMethod
  public void testCreateProject() {
    LoginPage login = new LoginPage(driver);
    login.setUserName("sergio.landa@fundacion-jala.org");
    login.clickContinue();
    login.setPassword("P@ssw0rd");
    HomePage home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName(nameOfProject);
    project.clickSelectAccount("Fundacion Jala");
    projectMenu = project.clickCreate();
  }

  @Test
  public void testDeleteProject() {
    log.info(testClass, title);
    SettingsPage settingsPage = projectMenu.clickSettings();
    homePage = settingsPage.deleteProject();
    ProjectsWorkSpacesPage projectsWorkSpacesPage = homePage.clickProjectsAndWorkSpaces();
    projectsWorkSpacesPage.clickLinkShowProjects(nameOfProject);
    assertFalse(projectsWorkSpacesPage.existProject());
    log.info(testClass, "Verify that the project does not exist");
  }

  @AfterTest
  public void logOutProfile() {
    homePage.LogOut();
  }
}
