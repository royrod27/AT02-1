package org.fundacion.automation.projects;

import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 12/13/2016.
 */
public class CreatePrivateProjectTest extends Base {

  @Test
  public void createPrivateProject() {
    log.info("CreatePrivateProjectTest", "Verify that is possible add a private project.");

    driver.get(configurationObj.getProperty("url"));
    LoginPage login = new LoginPage(driver);
    login.setUserName(configurationObj.getProperty("userName"));
    login.clickContinue();
    login.setPassword(configurationObj.getProperty("userPassword"));

    home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    String nameOfProject = "projectTestTwo";
    project.setProjectName(nameOfProject);
    project.clickSelectAccount("Jala");
    project.selectPrivacy("private");
    ProjectMenuPage projectMenuPage = project.clickCreate();
    SettingsPage settingsPage = projectMenuPage.clickSettings();

    boolean isPrivate = settingsPage.verifyPrivateAccess();

    assertTrue(isPrivate, "project is not private");
    log.info("CreatePrivateProjectTest", "Expect result: The project was created is private.");
    settingsPage.deleteProject();
  }

}
