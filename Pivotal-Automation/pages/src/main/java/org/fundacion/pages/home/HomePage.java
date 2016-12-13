package org.fundacion.pages.home;

import org.fundacion.pages.projects.CreateProjectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Topo on 9/12/2016.
 */
public class HomePage {

    private WebDriver driver;

    @FindBy(css = "#elm-root > div > div.DashboardV2__Tabs__background > div > div.DashboardV2__Tabs__ActionButton > button")
    WebElement createProjectBtn;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateProjectPage clickCreateProject(){
        createProjectBtn.click();
        return new CreateProjectPage(this.driver);
    }



}
