package org.fundacion.model.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Topo on 9/12/2016.
 */
public class CreateProjectModel {

  public static final String projectName = "div.tc-project-name > label > input";

  public static final String createBtn = "button.tc-create-project-footer__button.tc-create-project-footer__button--submit";

  public static final String menuButton = "fieldset > div";

  public static final String selectAccountItem = "div.tc-account-selector__options > ul > li:nth-child(1)";

  public static final String typeProject = "//fieldset/label/input";

  public static final String accountItem = "//div[text()= '";

}
