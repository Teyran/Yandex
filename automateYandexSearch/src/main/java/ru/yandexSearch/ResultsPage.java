package ru.yandexSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage {
  private WebDriver driver;

  public ResultsPage(WebDriver driver) {
    this.driver = driver;
  }

  private By searchField = By.xpath("//input[@class='input__control mini-suggest__input']");
  private By listOfResults = By.xpath("//ul[@class='serp-list serp-list_left_yes']/li");
  private By countOfResultsLabel = By.xpath("//div[@class='serp-adv__found']");

  public String getTextFromSearchField() {
    return driver.findElement(searchField).getAttribute("value");
  }

  public List<WebElement> getListOfResults () {
    return driver.findElements(listOfResults);
  }

  public WebElement getCountOfResultsLabel() {
    return driver.findElement(countOfResultsLabel);
  }
}
