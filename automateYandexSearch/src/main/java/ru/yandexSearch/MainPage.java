package ru.yandexSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
  private WebDriver driver;

  public MainPage(WebDriver driver) {
    this.driver = driver;
  }

  private By searchField = By.xpath("//input[@class='input__control input__input' and @id='text']");
  public By listOfSuggestions = By.xpath("//div[@class='popup__content']//li");
  private By searchButton = By.xpath("//button[@type='submit']");

  public MainPage typeSearchRequest(String request) {
    driver.findElement(searchField).sendKeys(request);
    return this;
  }

  public List<WebElement> getShownSuggestions()  {
    return driver.findElements(listOfSuggestions);
  }

}
