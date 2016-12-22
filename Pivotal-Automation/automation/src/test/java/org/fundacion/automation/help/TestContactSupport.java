package org.fundacion.automation.help;

import org.fundacion.automation.projects.Base;
import org.fundacion.pages.help.ContactSupportPage;
import org.fundacion.pages.help.FeedBackPage;
import org.fundacion.pages.login.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by fmiquiza on 22/12/2016.
 */
public class TestContactSupport extends Base {
    String title = "Test Contact Support Page";
    String testClass = "TestContactSupport";

    /** Login Method.
     *
     */
    @BeforeMethod
    public void login() {
        driver.get(configurationObj.getProperty("url"));
        LoginPage login = new LoginPage(driver);
        login.setUserName(configurationObj.getProperty("userName"));
        login.clickContinue();
        login.setPassword(configurationObj.getProperty("userPassword"));
        home = login.clickSubmit();
    }

    @Test
    public void verifyContactSupportLinkTakesToContactSupportPage() {
        log.info(testClass, title);

        ContactSupportPage contactSupportPage = home.clickContactSupportLink();
        assertTrue(contactSupportPage.verifyContactSupport());

        log.info(testClass, "Verify that Contact Link redirects to Contact Support and page title is ¨Contact Support");
    }
}
