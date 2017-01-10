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
  public void loginWebPage() throws Throwable {
    driver = Driver.getDriver().openBrowser();
  }

  @When("^I insert my account name (.*?)$")
  public void insertAccount(String userName) throws Throwable {
    loginPage = new LoginPage(driver);
    loginPage.setUserName(userName);
  }

  @When("^I press NEXT button$")
  public void pressNextButton() throws Throwable {
    loginPage.clickContinue();
  }

  @When("^I insert my password (.*?)$")
  public void insertPassword(String password) throws Throwable {
    loginPage.setPassword(password);
  }

  @When("^I press SIGN IN button$")
  public void pressSingIn() throws Throwable {
    loginPage.clickSubmit();
  }

  @Then("^I should see the HomePage of Pivotal Tracker (.*?)$")
  public void dashboardVerification(String dashboardPage) throws Throwable {
    String actualWebPage = driver.getCurrentUrl();
    assertEquals(actualWebPage, dashboardPage);
  }
}
