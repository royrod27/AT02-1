package org.fundacion.automation.projects;
import org.fundacion.automation.ABase;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectMenuPage;
import org.fundacion.pages.projects.ProjectsWorkSpacesPage;
import org.fundacion.pages.projects.SettingsPage;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
/**
 * Created by SergioLanda on 12/20/2016.
 */
public class TestDeleteProject extends ABase {
    ProjectMenuPage projectMenu;
    String nameOfProject = "test01";
    HomePage homePage;

    @BeforeMethod
    public void testCreateProject() {
        driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
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
        SettingsPage settingsPage = projectMenu.clickSettings();
        homePage = settingsPage.deleteProject();
        ProjectsWorkSpacesPage projectsWorkSpacesPage = homePage.clickProjectsAndWorkSpaces();
        projectsWorkSpacesPage.clickLinkShowProjects(nameOfProject);
        log.errorLog("TestDeleteProject","This is an error");
        assertFalse(projectsWorkSpacesPage.existProject());
    }

    @AfterMethod
    public void logOutProfile() {
        homePage.LogOut();
    }
}
