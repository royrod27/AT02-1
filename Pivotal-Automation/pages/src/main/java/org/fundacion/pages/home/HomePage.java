package org.fundacion.pages.home;

import org.fundacion.model.home.HomeModel;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectsWorkSpacesPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Topo on 9/12/2016.
 */
public class HomePage {

  private WebDriver driver;

  @FindBy(xpath = HomeModel.createProjectBtn)
  WebElement createProjectBtn;

  @FindBy(xpath = HomeModel.pivotalBtn)
  private WebElement pivotalBtn;

  @FindBy(css = HomeModel.workspaceTab)
  WebElement workspaceTab;

  @FindBy(css = HomeModel.createWorkspaceButton)
  WebElement createWorkspace;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public CreateProjectPage clickCreateProject() {
    createProjectBtn.click();
    return new CreateProjectPage(this.driver);
  }

  public ProjectsWorkSpacesPage clickProjectsAndWorkSpaces() {
    pivotalBtn.click();
    return new ProjectsWorkSpacesPage(driver);
  }

  public void clickWorkspaceTab() {
    workspaceTab.click();
  }
  
  public CreateWorkspacePage clickCreateWorkspaceLink() {
    createWorkspace.click();
    return new CreateWorkspacePage(driver);
  }

}
