package org.bdd.automation.task;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src\\test\\resources\\Tasks.feature",
        format = {"pretty", "html:reports/cucumberReport"}
)
public class TasksRunner extends AbstractTestNGCucumberTests{
}