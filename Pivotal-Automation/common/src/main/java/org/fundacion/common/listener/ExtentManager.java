package org.fundacion.common.listener;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.net.UnknownHostException;


/**
 * Created by Administrator on 12/14/2016.
 */
public class ExtentManager {

  private static ExtentReports extent;

  /**
   * getInstance.
   *
   * @return instance
   */
  public static ExtentReports getInstance() {
    if (extent == null) {
      createInstance("test-output/extent.html");
    }
    return extent;
  }

  /**
   * Create new instance.
   *
   * @param fileName name of file.
   * @return ExtentReports instance
   */
  public static ExtentReports createInstance(String fileName) {
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
    htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
    htmlReporter.config().setChartVisibilityOnOpen(true);
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setDocumentTitle(fileName);
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName(fileName);

    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("User Name", System.getProperty("user.name"));
    extent.setSystemInfo("OS", System.getProperty("os.name"));
    extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    try {
      java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
      extent.setSystemInfo("Host Name", localMachine.getHostName());
    } catch (UnknownHostException exception) {
      exception.printStackTrace();
    }
    return extent;
  }
}
