package org.fundacion.pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Topo on 9/12/2016.
 */
public class CreateProjectPage {

    WebDriver driver;
    @FindBy(css = "#modal_area > div > div.tc_modal.tc_modal_v1.tc-project-modal > div > form > div > div > div.tc-project-name > label > input")
    WebElement projectName;

    @FindBy(css = "#modal_area > div > div.tc_modal.tc_modal_v1.tc-project-modal > div > form > footer > button.tc-create-project-footer__button.tc-create-project-footer__button--submit")
    WebElement createBtn;

    @FindBy(css = " div.tc-account-selector__header")
    WebElement selectAccount;

    @FindBy(css = "div.tc-account-selector__options")
    WebElement selector;

    @FindBy(css = "//div[text()= '")
    WebElement account;

    public CreateProjectPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setProjectName(String name)
    {
        projectName.sendKeys(name);
    }

    public ProjectMenuPage clickCreate()
    {
        createBtn.click();
        return new ProjectMenuPage(this.driver);
    }

    public void clickSelectAccount(String accountName){
        selectAccount.click();

        account = selector.findElement(By.xpath("//div[text()= '" + accountName + "']")) ;
        account.click();
    }



}
