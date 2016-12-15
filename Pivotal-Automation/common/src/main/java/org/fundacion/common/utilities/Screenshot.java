package org.fundacion.common.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Screenshot {
    static SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy hh-mm-ss");
    static Calendar now = Calendar.getInstance();

    public static void capture(WebDriver driver, ITestResult testResult) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("../automation/reports/screenShot/" + formatter.format(now.getTime())+".png"));

    }
}
