package org.fundacion.automation.projects;

import static org.testng.Assert.assertTrue;

import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.testng.annotations.Test;




public class ModifyProjectTest extends Base {
  @Test
  public void testModifyProject() {
    log.info("ModifyProjectTest", "Verify that is possible modify the name of a project.");
    driver.get(configurationObj.getProperty("url"));
    LoginPage login = new LoginPage(driver);
    login.setUserName(configurationObj.getProperty("userName"));
    login.clickContinue();
    login.setPassword(configurationObj.getProperty("userPassword"));
    home = login.clickSubmit();
    CreateProjectPage newProject = home.clickCreateProject();

    newProject.setProjectName("TestName");
    newProject.clickSelectAccount("Jala");
    ProjectMenuPage projectMenuPage = newProject.clickCreate();

    SettingsPage settingsPage = projectMenuPage.clickSettings();
    String projectNameChanged = "TestNameChanged";
    settingsPage.editProjectName(projectNameChanged);
    assertTrue(driver.findElement(settingsPage.getTitleProject(projectNameChanged)).isDisplayed(),
            "Error the name of the project is different.");
    log.info("ModifyProjectTest", "Expect result: The project has correctly changed its name.");

    settingsPage.deleteProject();
  }

}