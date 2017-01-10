package org.bdd.automation.login;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

/**
 * Created by Administrator on 1/9/2017.
 */

public class LoginSteps {
  WebDriver driver;
  LoginPage loginPage;

  @Given("^I am on the Pivotal Tracker login page$")
  public void iAmOnThePivotalTrackerLoginPage() throws Throwable {
    driver = Driver.getDriver().openBrowser();
  }

  @When("^I insert my account name (.*?)$")
  public void i_insert_my_account_name_Roy_Rodriguez_fundacion_jala_org(String userName) throws Throwable {
    loginPage = new LoginPage(driver);
    loginPage.setUserName(userName);
  }

  @When("^I press NEXT button$")
  public void i_press_NEXT_button() throws Throwable {
    loginPage.clickContinue();
  }

  @When("^I insert my password (.*?)$")
  public void i_insert_my_password_Sabbath(String password) throws Throwable {
    loginPage.setPassword(password);
  }

  @When("^I press SIGN IN button$")
  public void i_press_SIGN_IN_button() throws Throwable {
    loginPage.clickSubmit();
  }

  @Then("^I should see the HomePage of Pivotal Tracker (.*?)$")
  public void i_should_see_the_HomePage_of_Pivotal_Tracker(String dashboardPage) throws Throwable {
    String actualWebPage = driver.getCurrentUrl();
    assertEquals(actualWebPage, dashboardPage);
  }
}
