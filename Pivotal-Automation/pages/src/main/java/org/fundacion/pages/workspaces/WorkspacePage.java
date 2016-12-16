package org.fundacion.pages.workspaces;

import org.fundacion.model.workspaces.SettingsWorkspaceModel;
import org.fundacion.model.workspaces.WorkspaceModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by David on 12/15/2016.
 */
public class WorkspacePage {
  WebDriver driver;
  WebDriverWait wait;

  public WorkspacePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(css = WorkspaceModel.workspaceTitle)
  WebElement title;

  @FindBy(css = WorkspaceModel.settingLink)
  WebElement setting;


  @FindBy(id = WorkspaceModel.addRemoveButton)
  WebElement addRemoveButton;

  @FindBy(xpath = WorkspaceModel.addRemoveOption)
  List<WebElement> addRemoveOption;

  public boolean workspaceTitle(String title) {
//    String expect = this.title.getText();
//    String actual = title;
    wait.until(ExpectedConditions.elementToBeClickable(setting));
    return this.title.getText().equals(title);
  }

  public SettingsWorkspacePage settingsWorkspace() {
    wait.until(ExpectedConditions.elementToBeClickable(setting));
    setting.click();
    return new SettingsWorkspacePage(driver);
  }

  public ManageWorkspacePage addProjectOption() {
    wait.until(ExpectedConditions.elementToBeClickable(addRemoveButton));
    addRemoveButton.click();

    for (WebElement element:addRemoveOption) {
      if(element.getAttribute("class").equals("add_projects")){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
      }
    }




    return new ManageWorkspacePage(driver);
  }
}
