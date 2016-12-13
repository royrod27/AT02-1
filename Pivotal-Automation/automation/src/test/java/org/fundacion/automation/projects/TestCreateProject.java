package org.fundacion.automation.projects;


import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.fundacion.pages.projects.ProjectMenuPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class TestCreateProject

{


    @Test
    public void verifyIfProjectIsCreated() {

        System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.pivotaltracker.com/signin");

        LoginPage login = new LoginPage(driver);
        login.setUserName("fernando.iquiza@fundacion-jala.org");
        login.clickContinue();
        login.setPassword("MTat676435019");
        HomePage home = login.clickSubmit();
        CreateProjectPage project = home.clickCreateProject();
        project.setProjectName("ProjectCreated");
        project.clickSelectAccount("Fundacion Jala");
        ProjectMenuPage projectMenu = project.clickCreate();

        assertTrue(projectMenu.verifyProjectName("ProjectCreated"),"Error the name of the project is different. ");
        }



    @AfterClass
        public void Close()
        {
           // driver.quit();
        }

}
