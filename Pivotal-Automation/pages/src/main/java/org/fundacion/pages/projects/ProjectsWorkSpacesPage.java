package org.fundacion.pages.projects;

import org.fundacion.model.projects.ProjectsWorkSpacesModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 12/13/2016.
 */
public class ProjectsWorkSpacesPage {
  WebDriver driver;
  WebDriverWait wait;
  String nameOfProject;

  public ProjectsWorkSpacesPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(this.driver, 20);
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = ProjectsWorkSpacesModel.linkShowProjects)
  private WebElement linkShowProjects;

  @FindBy(xpath = ProjectsWorkSpacesModel.project)
  private WebElement project;

//  @FindBy(xpath = "//div/header/ul/li[3]/div")
//  WebElement projectProfileName;

  public boolean existProject() {
    return project.getText().equalsIgnoreCase(nameOfProject);
  }

//  public void clickProfileName(){
//    wait.until(ExpectedConditions.elementToBeClickable(projectProfileName));
//    projectProfileName.click();
//  }


  public void clickLinkShowProjects(String nameOfProject) {
    this.nameOfProject=nameOfProject;
    linkShowProjects.click();
  }
}
