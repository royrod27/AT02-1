package org.fundacion.pages.workspaces;

import org.fundacion.model.workspaces.ManageWorkspaceModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by David on 12/16/2016.
 */
public class ManageWorkspacePage {
  WebDriver driver;
  WebDriverWait wait;

  public ManageWorkspacePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(css = ManageWorkspaceModel.selectProject)
  WebElement selectProject;

  @FindBy(css = ManageWorkspaceModel.saveProject)
  WebElement saveProject;

  @FindBy(xpath = ManageWorkspaceModel.projectName)
  List<WebElement> projectName;

  @FindBy(xpath = ManageWorkspaceModel.projectRemove)
  List<WebElement> projectRemove;

  public void addWorkspaceProject(String projectName) {
    wait.until(ExpectedConditions.elementToBeClickable(selectProject));
    selectProject.click();
    WebElement project = driver.findElement(By.xpath("//span[text()= '" + projectName + "']"));
    project.click();
    saveProject.click();
  }

  public void removeProject(String name) {
    for (WebElement element : projectName) {
      if (element.getText().equals(name.toUpperCase())){
        for (WebElement remove : projectRemove) {
          remove.click();
        }
      }
    }
    saveProject.click();
  }
}
