package org.fundacion.model.projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 12/13/2016.
 */
public class SettingsModel {
  public static final String deleteButton = "delete_link";

  public static final String deleteConfirm = "confirm_delete";

  public static final String pivotalTrackerIcon = "header > ul > li:nth-child(1) > a";

  public static final String publicAccessCheckBox = "//*[@id=\"project_public\"]";

  public static final String projectName = "project_name";

  public static final String saveBtn = ".save_bar__submit";

  public static final String linkNameProjectAccount = "//*[@id=\"project_account_link\"]";

}
