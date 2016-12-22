package org.fundacion.common.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.fundacion.common.drivers.Driver;
import org.fundacion.common.utilities.Screenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


/**
 * Created by Administrator on 12/14/2016.
 */
public class ExtentListener implements ITestListener {
  WebDriver driver;
  Screenshot screenshot = new Screenshot();

  private SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy hh-mm-ss");
  private Calendar now = Calendar.getInstance();
  private static ExtentReports extent = ExtentManager
          .createInstance("../automation/reports/extentReport/report.html");
  private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();
  private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();


  public void onTestStart(ITestResult testResult) {
    ExtentTest child = parentTest.get().createNode(testResult.getMethod().getMethodName());
    test.set(child);
  }

  public void onTestSuccess(ITestResult testResult) {
    test.get().pass("Test passed");
  }

  /**
   * TestFailure.
   *
   * @param testResult result of test.
   */
  public void onTestFailure(ITestResult testResult) {
    test.get().fail(testResult.getThrowable());


    try {
      driver = Driver.getDriver().openBrowser();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      test.get().log(Status.FAIL, testResult.getName() + "_"
              + formatter.format(now.getTime()) + ".png")
              .addScreenCaptureFromPath(screenshot.capture(driver, testResult));
      System.setProperty("org.uncommons.reportng.escape-output", "false");
      Reporter.log("<a href=../" +screenshot.capture(driver, testResult)+ "> " + testResult.getName() +  ".png </a>");

    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  public void onTestSkipped(ITestResult testResult) {
    test.get().skip(testResult.getThrowable());
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {

  }

  public void onStart(ITestContext testContext) {
    ExtentTest parent = extent.createTest(getClass().getName());
    parentTest.set(parent);
  }

  public void onFinish(ITestContext testContext) {
    extent.flush();
  }
}
