package org.fundacion.pages.help;

import org.fundacion.model.help.HelpMainModel;
import org.fundacion.pages.help.QuickStartHelp;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Fernando on 12/19/2016.
 */
public class HelpPageMain {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = HelpMainModel.getStartedBtn)
  WebElement getStartedBtn;

  @FindBy(xpath = HelpMainModel.learnMoreBtn)
  WebElement learnMoreBtn;

  @FindBy(xpath = HelpMainModel.helpPageTitle)
  WebElement helpPageTitle;

  @FindBy(css = HelpMainModel.message)
  WebElement message;

  @FindBy(xpath = HelpMainModel.quickStartTitle)
  WebElement quickStartTitle;

  @FindBy(xpath = "//a[text()='Help']")
  WebElement helpLink;

  public HelpPageMain(WebDriver driver) {

    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickGetStartedBtn() {
    getStartedBtn.click();
  }

  public boolean changeTab() {
boolean flag = false;
    try {

      Thread.sleep(5000);
      ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
      System.out.println(tabs2.size());

      for (int i = tabs2.size() - 1; i >= 0; i--) {
        Thread.sleep(2000);
        driver.switchTo().window(tabs2.get(i));
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        System.out.println(driver.getTitle() + " Titulo web: " + i);

        clickGetStartedBtn();
        flag = quickStartTitle.getText().equals(driver.getTitle());

      }
    } catch (Exception e) {
    }
    return flag;
  }


  public boolean verifyTitle() {
    changeTab();
    System.out.println(quickStartTitle.getText());
    System.out.println(driver.getTitle());
    return quickStartTitle.getText().equals(driver.getTitle());
  }

  public boolean verifyMessage(String text) {
    return message.getText().equals(text);
  }

  public QuickStartHelp quickStartHelp() {
    return new QuickStartHelp(driver);
  }


}
