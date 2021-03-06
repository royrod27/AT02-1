package org.fundacion.pages.task;

import org.fundacion.model.task.TaskModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Angelica Rodriguez on 12/19/2016.
 */
public class TaskPage {

  WebDriver driver;
  WebDriverWait wait;

  @FindBy(xpath = TaskModel.addBtn)
  WebElement addButton;

  @FindBy(css = TaskModel.nameTxt)
  WebElement nameTask;

  @FindBy(xpath = TaskModel.listTask)
  WebElement listTask;

  @FindBy(xpath = TaskModel.deleteBtn)
  WebElement deleteButton;

  @FindBy(xpath = TaskModel.navOpt)
  WebElement navigate;

  @FindBy(xpath = TaskModel.alertDialog)
  WebElement alertDialog;

  @FindBy(xpath = TaskModel.checkInput)
  WebElement checkInput;

  @FindBy(xpath = TaskModel.editBtn)
  WebElement editButton;

  @FindBy(xpath = TaskModel.nameEdit)
  WebElement txtEdit;

  @FindBy(xpath = TaskModel.saveEdit)
  WebElement saveEditButtom;

  @FindBy(xpath = TaskModel.buttonOk)
  WebElement buttonOk;

  @FindBy(xpath = TaskModel.countTask)
  WebElement countTask;


  public TaskPage(WebDriver driver) {
    this.driver = driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    PageFactory.initElements(driver, this);
  }

  public void addTask(String name) {
    nameTask.sendKeys(name);
    addButton.click();
    if (name.isEmpty()) {
      alertDialog();
    }
  }

  public String alertDialog() {
    return alertDialog.getText();
  }

  public void deleteTask(String name) {
    navigate.findElement(By.xpath("//div[text()= '" + name + "']"));
    checkInput.click();
    deleteButton.click();
  }

  public void editTask(String name) {
    navigate.findElement(By.xpath("//div[text()= '" + name + "']"));
    checkInput.click();
    editButton.click();
  }

  public void inputNewName(String nameNew) {

    txtEdit.clear();
    txtEdit.sendKeys(nameNew);
    saveEditButtom.click();
  }

  public boolean contentNameTask(String nameAccount) {
    return listTask.getText().contains(nameAccount) ? true : false;
  }


  public void clickButtonOk() {
    buttonOk.click();
  }

  public int sizeContentNameTask(String name) {
    Integer count = 0;
    List<WebElement> elementTabla = driver.findElements(By.xpath("//section[5]/div/div/div[1]/div"));
    for (WebElement elementFind : elementTabla) {

      if (elementFind.getText().equals(name))
        count++;
    }
    return count;
  }

}
