package org.fundacion.common.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by SergioLanda on 12/20/2016.
 */
public class WebDriverTools {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Logger log = Logger.getLogger(getClass());

    public WebDriverTools(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public void waitUntilElementVisible(WebElement webElement) {
        try {
            this.webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (WebDriverException e) {
            log.error(String.format("Element is not visible: %s", e.getMessage()));
        }
    }

    public void clearAndSendKeys(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
        } catch (WebDriverException e) {
            log.error(String.format("Error when trying to clear and send key: %s, error message: %s", webElement, e.getCause()));
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            log.info(String.format("The click action was performed on web element: %s", webElement));
        } catch (WebDriverException e) {
            log.error(String.format("Error when trying to click on web element: %s, error message: %s", webElement, e.getCause()));
        }
    }
}