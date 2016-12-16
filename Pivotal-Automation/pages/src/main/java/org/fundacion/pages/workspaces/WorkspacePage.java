package org.fundacion.pages.workspaces;

import org.fundacion.model.workspaces.WorkspaceModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by David on 12/15/2016.
 */
public class WorkspacePage {
  WebDriver driver;

  public WorkspacePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = WorkspaceModel.workspaceTitle)
  WebElement title;

  public boolean workspaceTitle(String title) {
    return title.equals(title);
  }
}
