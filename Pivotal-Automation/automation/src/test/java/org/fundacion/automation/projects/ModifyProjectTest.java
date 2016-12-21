package org.fundacion.automation.projects;

import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;


public class ModifyProjectTest extends Base {
  @Test
  public void testCreateProject() {
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
    log.info("ModifyProjectTest", "Expect result: The project created was changed the name.");

    settingsPage.deleteProject();
  }

}