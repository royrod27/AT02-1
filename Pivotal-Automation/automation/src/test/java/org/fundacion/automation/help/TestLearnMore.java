package org.fundacion.automation.help;

import org.fundacion.automation.projects.Base;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.help.HelpPageMain;
import org.fundacion.pages.help.LearnMorePage;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Fernando on 21/12/2016.
 */
public class TestLearnMore extends Base {
    HomePage home;

    @Test
    public void verifyLearnMorePageTitleCorrectlyLoaded() {
        driver = Driver.getDriver().openBrowser();
        driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
        LoginPage login = new LoginPage(driver);
        login.setUserName("fernando.iquiza@fundacion-jala.org");
        login.clickContinue();
        login.setPassword("MTat676435019");
        home = login.clickSubmit();

        LearnMorePage learnMorePage = home.clickLearnMoreButton();

        assertTrue(learnMorePage.verifyLearnMore());

    }
    @AfterClass
    public void logOutProfile() {
        home.LogOut();
    }
}
