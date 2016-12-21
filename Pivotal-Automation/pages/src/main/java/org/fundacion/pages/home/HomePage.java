package org.fundacion.pages.home;

import org.fundacion.model.help.HelpMainModel;
import org.fundacion.model.home.HomeModel;
import org.fundacion.pages.help.ApiDocumentationPage;
import org.fundacion.pages.help.HelpPageMain;
import org.fundacion.pages.help.LearnMorePage;
import org.fundacion.pages.help.QuickStartHelp;
import org.fundacion.pages.projects.CreateProjectPage;
import org.fundacion.pages.projects.ProjectsWorkSpacesPage;
import org.fundacion.pages.workspaces.CreateWorkspacePage;
import org.fundacion.pages.workspaces.WorkspaceListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

  @FindBy(xpath = HomeModel.logOutBtn)
  WebElement logOutBtn;

  @FindBy(xpath = HomeModel.signOutBtn)
  WebElement signOutBtn;

  @FindBy(xpath = HomeModel.helpLink)
  WebElement helpLink;


  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public CreateProjectPage clickCreateProject() {
    createProjectBtn.click();
    return new CreateProjectPage(this.driver);
  }

  public void logOut() {
      logOutBtn.click();
      signOutBtn.click();
  }

  public ProjectsWorkSpacesPage clickProjectsAndWorkSpaces() {
    pivotalBtn.click();
    return new ProjectsWorkSpacesPage(driver);
  }

  public WorkspaceListPage clickWorkspaceTab() {
    workspaceTab.click();
    return new WorkspaceListPage(driver);
  }

  public HelpPageMain clickHelpPageButton(){
    helpLink.click();
    return new HelpPageMain(driver);
  }

  public CreateWorkspacePage clickCreateWorkspaceLink() {
    createWorkspace.click();
    return new CreateWorkspacePage(driver);
  }

  public LearnMorePage clickLearnMoreButton(){
    helpLink.click();
    return new LearnMorePage(driver);
  }

}
