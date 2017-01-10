package org.bdd.automation.login;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src\\test\\resources\\Login.feature",
format = {"pretty", "html:reports/cucumberReport"}
)

public class LoginRunner extends AbstractTestNGCucumberTests{}
