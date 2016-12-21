package org.fundacion.pages.help;

import org.fundacion.model.help.HelpMainModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 */
public class LearnMorePage {
    private WebDriver driver;

    @FindBy(xpath = HelpMainModel.learnMoreBtn)
    WebElement learnMoreBtn;

    @FindBy(xpath = "//h1")
    WebElement learnMoreTitle;

    public LearnMorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean verifyLearnMore() {
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

                learnMoreBtn.click();
                flag =  learnMoreTitle.getText().equals(driver.getTitle());
                driver.close();
            }
        } catch (Exception e) {
        }
        return flag;
    }


}
