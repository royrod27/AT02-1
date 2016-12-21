package org.fundacion.pages.help;

import org.fundacion.model.help.ApiDocumentationModel;
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
public class ApiDocumentationPage {
    WebDriver driver;

    public ApiDocumentationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ApiDocumentationModel.apiDocumentationBtn)
    WebElement apiDocumentationBtn;

    @FindBy(xpath = ApiDocumentationModel.apiDocumentationTitle)
    WebElement apiDocumentationTitle;


    public boolean verifyApiDocumentation() {
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

               apiDocumentationBtn.click();
//              flag =  apiDocumentationTitle.getText().equals(driver.getTitle());
                flag = apiDocumentationBtn.getText().equals(driver.getTitle().contains("Essentials"));

            }
        } catch (Exception e) {
        }
        return flag;
    }


}
