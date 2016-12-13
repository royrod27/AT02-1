package org.fundacion.pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Topo on 10/12/2016.
 */
public class ProjectMenuPage {

    WebDriver driver;

    @FindBy(xpath = "//h1/a/span/span")
    WebElement projectNameElement;

    public ProjectMenuPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProjectName(String projectName)
    {
        return projectNameElement.getText().equalsIgnoreCase(projectName) ? true : false;
    }
}
