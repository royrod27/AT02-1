package org.fundacion.pages.stories;

import org.fundacion.model.story.StoryModel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by JorgeForero on 12/15/2016.
 */
public class StoryPage {
  WebDriver driver;

  @FindBy(name = StoryModel.storyTitleTextArea)
  private WebElement storyTitleTextArea;

  @FindBy(xpath = StoryModel.saveStoryButton)
  WebElement saveStoryButton;

  @FindBy(xpath = StoryModel.cancelCreateStoryButton)
  WebElement cancelCreateStoryButton;

  @FindBy(xpath = StoryModel.editDescriptionButton)
  WebElement editDescriptionButton;

  @FindBy(name = StoryModel.storyDescriptionTextField)
  WebElement storyDescriptionTextField;

  @FindBy(xpath = StoryModel.doneDescriptionButton)
  WebElement doneDescriptionButton;

  @FindBy(css = StoryModel.storyExpander)
  WebElement storyExpander;

  @FindBy(id = StoryModel.comment)
  private WebElement comment;

  @FindBy(css = StoryModel.addCommentButton)
  private WebElement addCommentButton;

  @FindBy(xpath = StoryModel.deleteStoryButton)
  WebElement deleteStoryButton;

  @FindBy(xpath = StoryModel.confirmDeleteButton)
  WebElement confirmDeleteButton;

  @FindBy(xpath = StoryModel.storyDeletedMessage)
  WebElement storyDeletedMessage;

  @FindBy(xpath = StoryModel.cancelDeleteButton)
  WebElement cancelDeleteButton;

  public StoryPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void setTitleStory(String name) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    storyTitleTextArea.sendKeys(name);
  }

  public void clickOnCreateStory() {
    saveStoryButton.click();
  }

  public void clickOnExpandStory() {
    storyExpander.click();
  }

  public String getStoryName() {
    return storyTitleTextArea.getText();
  }

  public void setDescriptionTextarea(String storyDescription) {
    editDescriptionButton.click();
    storyDescriptionTextField.clear();
    storyDescriptionTextField.sendKeys(storyDescription);
    doneDescriptionButton.click();
  }

  public void setComment(String storyComment) {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].scrollIntoView();", addCommentButton);
    comment.clear();
    comment.sendKeys(storyComment);
    addCommentButton.click();
  }

  public void clickDeleteStory() {
    deleteStoryButton.click();
    confirmDeleteButton.click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
