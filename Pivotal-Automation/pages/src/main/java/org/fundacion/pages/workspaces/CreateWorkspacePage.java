package org.fundacion.pages.workspaces;

import org.fundacion.model.workspaces.CreateWorkspaceModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by David on 12/15/2016.
 */
public class CreateWorkspacePage {
  WebDriver driver;
  WebDriverWait wait;

  public CreateWorkspacePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(css = CreateWorkspaceModel.workspaceName)
  WebElement workspaceName;

  @FindBy(css = CreateWorkspaceModel.createWorkspaceButton)
  WebElement createWorkspaceButton;

  @FindBy(css = CreateWorkspaceModel.cancelWorkspaceButton)
  WebElement cancelWorkspaceButton;

  public void setWorkspaceName(String name) {
    workspaceName.sendKeys(name);
  }

  public WorkspacePage clickCreateWorkspace() {
    createWorkspaceButton.click();
    return new WorkspacePage(driver);
  }

}
