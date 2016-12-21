package org.fundacion.automation.projects;

import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.SettingsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;


/**
 * Created by Administrator on 12/13/2016.
 */
public class CreatePublicProjectTest extends Base {

  @Test
  public void testCreatePublicProject() {
    log.info("CreatePublicProjectTest", "Verify that is possible add a public project.");
    driver.get(configurationObj.getProperty("url"));
    LoginPage login = new LoginPage(driver);
    login.setUserName(configurationObj.getProperty("userName"));
    login.clickContinue();
    login.setPassword(configurationObj.getProperty("userPassword"));
    home = login.clickSubmit();
    CreateProjectPage project = home.clickCreateProject();
    project.setProjectName("TestPublic");
    project.clickSelectAccount("Jala");
    project.selectPrivacy("public");

    ProjectMenuPage projectMenuPage = project.clickCreate();
    SettingsPage settingsPage = projectMenuPage.clickSettings();

    boolean isPrivate = settingsPage.verifyPrivateAccess();

    assertFalse(isPrivate, "project is public");
    log.info("CreatePrivateProjectTest", "Expect result: The project was created is public.");
    settingsPage.deleteProject();

  }

}
